package com.bartsch.costlydiet.service.implementation;

import com.bartsch.costlydiet.model.mapper.RecipeMapper;
import com.bartsch.costlydiet.repository.IngredientRepository;
import com.bartsch.costlydiet.repository.RecipeRepository;
import com.bartsch.costlydiet.model.dto.recipe.RecipeDetailDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeUpdateReqDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeCreateReqDto;
import com.bartsch.costlydiet.model.entity.Ingredient;
import com.bartsch.costlydiet.model.entity.Recipe;
import com.bartsch.costlydiet.model.entity.RecipeIngredient;
import com.bartsch.costlydiet.model.dto.recipeingredient.RecipeIngredientDetailDto;
import com.bartsch.costlydiet.model.dto.recipeingredient.RecipeIngredientCreateReqDto;
import com.bartsch.costlydiet.service.RecipeService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;
  private final RecipeMapper recipeMapper;
  private final IngredientRepository ingredientRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper,
      IngredientRepository ingredientRepository) {
    this.recipeRepository = recipeRepository;
    this.recipeMapper = recipeMapper;
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public List<RecipeSearchResDto> searchRecipes(String name) {
    name = name == null ? "" : name;
    return recipeMapper.toRecipeSearchResDtoList(recipeRepository.searchByNameContains(name));
  }

  @Override
  public RecipeDetailDto getRecipe(Long id) {
    Recipe recipe = recipeRepository.findByIdWithIngredients(id)
        .orElseThrow(() -> new EntityNotFoundException("Recipe not found"));

    List<RecipeIngredientDetailDto> ingredientDtos = recipe.getRecipeIngredients().stream()
        .map(ri -> {
          long price = Math.round(ri.getAmount() * (ri.getIngredient().getPrice() / 1000.0));
          long calories = Math.round(ri.getAmount() * (ri.getIngredient().getCalories() / 100.0));

          return RecipeIngredientDetailDto.builder()
              .id(ri.getIngredient().getId())
              .name(ri.getIngredient().getName())
              .amount(ri.getAmount())
              .price(price)
              .calories(calories)
              .build();
        }).toList();

    long amountTotal = ingredientDtos.stream().mapToLong(RecipeIngredientDetailDto::getAmount).sum();
    long priceTotal = ingredientDtos.stream().mapToLong(RecipeIngredientDetailDto::getPrice).sum();
    long caloriesTotal = ingredientDtos.stream().mapToLong(RecipeIngredientDetailDto::getCalories).sum();

    return RecipeDetailDto.builder()
        .id(recipe.getId())
        .name(recipe.getName())
        .instructions(recipe.getInstructions())
        .recipeIngredients(ingredientDtos)
        .amountTotal(amountTotal)
        .priceTotal(priceTotal)
        .caloriesTotal(caloriesTotal)
        .build();
  }

  @Override
  public RecipeDetailDto createRecipe(RecipeCreateReqDto recipeCreateReqDto) {
    log.debug("creating recipe {}", recipeCreateReqDto);

    Recipe recipe = new Recipe();
    recipe.setName(recipeCreateReqDto.getName());
    recipe.setInstructions(recipeCreateReqDto.getInstructions());

    List<RecipeIngredient> ingredients = new ArrayList<>();
    for (RecipeIngredientCreateReqDto ingredientDto : recipeCreateReqDto.getRecipeIngredients()) {
      RecipeIngredient ri = new RecipeIngredient();
      ri.setAmount(ingredientDto.getAmount());

      // Fetch the actual Ingredient entity from the database
      Ingredient ingredient = this.ingredientRepository.findById(ingredientDto.getId())
          .orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID: " + ingredientDto.getId()));

      ri.setIngredient(ingredient);
      ri.setRecipe(recipe); // <<< this is the critical missing line

      ingredients.add(ri);
    }
    recipe.setRecipeIngredients(ingredients);

    Recipe savedRecipe = recipeRepository.save(recipe);
    return getRecipe(savedRecipe.getId());
  }

  @Transactional
  public RecipeDetailDto updateRecipe(Long id, RecipeUpdateReqDto recipeUpdateReqDto) {
    Recipe recipe = recipeRepository.findByIdWithIngredients(id)
        .orElseThrow(() -> new EntityNotFoundException("Recipe not found"));

    recipe.setName(recipeUpdateReqDto.getName());
    recipe.setInstructions(recipeUpdateReqDto.getInstructions());

    // 1. CLEAR the existing managed collection instead of creating a 'new
    // ArrayList<>()'
    recipe.getRecipeIngredients().clear();

    for (RecipeIngredientCreateReqDto ingredientDto : recipeUpdateReqDto.getRecipeIngredients()) {
      RecipeIngredient ri = new RecipeIngredient();
      ri.setAmount(ingredientDto.getAmount());

      Ingredient ingredient = this.ingredientRepository.findById(ingredientDto.getId())
          .orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID"));

      ri.setIngredient(ingredient);
      ri.setRecipe(recipe);

      // 2. ADD to the existing collection
      recipe.getRecipeIngredients().add(ri);
    }

    // Hibernate will now issue DELETEs for the old ones and INSERTs for the new
    // ones
    return recipeMapper.toRecipeDetailDto(recipe);
  }

}
