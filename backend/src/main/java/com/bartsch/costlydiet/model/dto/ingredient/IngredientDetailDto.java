package com.bartsch.costlydiet.model.dto.ingredient;

import lombok.Data;

@Data
public class IngredientDetailDto {
  private Long id;
  private String name;
  private long price; // in cents per kg
  private long calories;
  private String notes;
}
