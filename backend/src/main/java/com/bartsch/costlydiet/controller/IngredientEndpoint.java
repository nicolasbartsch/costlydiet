package com.bartsch.costlydiet.controller;

import com.bartsch.costlydiet.service.IngredientService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IngredientEndpoint {

  private final IngredientService ingredientService;

  public IngredientEndpoint(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

}
