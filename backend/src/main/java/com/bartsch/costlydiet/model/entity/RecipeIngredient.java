package com.bartsch.costlydiet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RecipeIngredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ingredient_id", nullable = false)
  private Ingredient ingredient;

  @ManyToOne(optional = false)
  @JoinColumn(name = "recipe_id", nullable = false)
  private Recipe recipe;

  @Column
  private long amount; // in grams
}
