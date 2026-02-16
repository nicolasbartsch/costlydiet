package com.bartsch.costlydiet.model.mapper;

import com.bartsch.costlydiet.model.entity.Recipe;
import com.bartsch.costlydiet.model.entity.RecipeIngredient;
import com.bartsch.costlydiet.model.dto.recipe.RecipeDetailDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;
import com.bartsch.costlydiet.model.dto.recipeingredient.RecipeIngredientDetailDto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
  RecipeSearchResDto toRecipeSearchResDto(Recipe recipe);

  List<RecipeSearchResDto> toRecipeSearchResDtoList(List<Recipe> recipes);

  @Mapping(source = "ingredient.id", target = "id")
  @Mapping(source = "ingredient.name", target = "name")
  @Mapping(source = "ingredient.price", target = "price")
  @Mapping(source = "amount", target = "amount")
  RecipeIngredientDetailDto toRecipeIngredientDetailDto(RecipeIngredient recipeIngredient);

  List<RecipeIngredientDetailDto> toRecipeIngredientDetailDtoList(List<RecipeIngredient> recipeIngredients);

  RecipeDetailDto toRecipeDetailDto(Recipe recipe);
}
