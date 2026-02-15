package com.bartsch.costlydiet.model.mapper;

import com.bartsch.costlydiet.model.entity.Recipe;
import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
  RecipeSearchResDto toRecipeSearchResDto(Recipe recipe);

  List<RecipeSearchResDto> toRecipeSearchResDtoList(List<Recipe> recipes);
}
