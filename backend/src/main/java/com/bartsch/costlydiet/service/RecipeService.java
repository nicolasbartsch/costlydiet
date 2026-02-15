package com.bartsch.costlydiet.service;

import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeCreateReqDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeDetailDto;

import java.util.List;

public interface RecipeService {
  List<RecipeSearchResDto> searchRecipes(String name);

  RecipeDetailDto getRecipe(Long id);

  RecipeDetailDto createRecipe(RecipeCreateReqDto recipeCreateReqDto);
}
