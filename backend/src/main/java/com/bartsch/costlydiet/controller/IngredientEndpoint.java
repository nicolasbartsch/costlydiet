package com.bartsch.costlydiet.controller;

import com.bartsch.costlydiet.model.dto.ingredient.IngredientSearchResDto;
import com.bartsch.costlydiet.service.IngredientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@RestController
@Slf4j
public class IngredientEndpoint {

  private final IngredientService ingredientService;

  public IngredientEndpoint(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping("/ingredients")
  public List<IngredientSearchResDto> searchIngredients(@RequestParam(required = false) String name) {
    log.info("getIngredients()");
    return ingredientService.searchIngredients(name);
  }

}
