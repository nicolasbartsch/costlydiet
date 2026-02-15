package com.bartsch.costlydiet.service;

import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;

import java.util.List;

public interface RecipeService {
  List<RecipeSearchResDto> searchRecipes(String name);
}
