package com.bartsch.costlydiet.service.implementation;

import com.bartsch.costlydiet.model.mapper.RecipeMapper;
import com.bartsch.costlydiet.repository.IngredientRepository;
import com.bartsch.costlydiet.repository.RecipeRepository;

import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;
import com.bartsch.costlydiet.service.RecipeService;
import lombok.extern.slf4j.Slf4j;

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

}
