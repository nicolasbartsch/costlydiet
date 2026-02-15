package com.bartsch.costlydiet.model.dto.recipe;

import com.bartsch.costlydiet.model.dto.recipeingredient.RecipeIngredientCreateReqDto;
import lombok.Data;

import java.util.List;

@Data
public class RecipeCreateReqDto {
  private String name;
  private String instructions;
  private List<RecipeIngredientCreateReqDto> recipeIngredients;
}
