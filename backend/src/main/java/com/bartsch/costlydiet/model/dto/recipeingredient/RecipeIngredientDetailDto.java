package com.bartsch.costlydiet.model.dto.recipeingredient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecipeIngredientDetailDto {
  private long id;
  private String name;
  private long amount;
  private long price;
  private long calories;
}
