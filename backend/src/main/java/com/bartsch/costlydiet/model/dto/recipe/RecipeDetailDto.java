package com.bartsch.costlydiet.model.dto.recipe;

import com.bartsch.costlydiet.model.dto.recipeingredient.RecipeIngredientDetailDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RecipeDetailDto {
  private Long id;
  private String name;
  private String instructions;
  private List<RecipeIngredientDetailDto> recipeIngredients;
  private long priceTotal;
  private long amountTotal;
  private long caloriesTotal;
}
