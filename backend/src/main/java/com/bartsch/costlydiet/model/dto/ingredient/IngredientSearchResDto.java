package com.bartsch.costlydiet.model.dto.ingredient;

import lombok.Data;

@Data
public class IngredientSearchResDto {
  private Long id;
  private String name;
  private Long price;
  private Long calories;
  private String notes;
}
