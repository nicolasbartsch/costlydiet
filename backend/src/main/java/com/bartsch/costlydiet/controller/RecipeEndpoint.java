package com.bartsch.costlydiet.controller;

import lombok.extern.slf4j.Slf4j;

import com.bartsch.costlydiet.service.RecipeService;

import java.util.List;

import com.bartsch.costlydiet.model.dto.recipe.RecipeSearchResDto;
import com.bartsch.costlydiet.model.dto.recipe.RecipeDetailDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "api/recipes")
public class RecipeEndpoint {

  private final RecipeService recipeService;

  public RecipeEndpoint(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping()
  public List<RecipeSearchResDto> searchRecipes(@RequestParam(required = false) String name) {
    log.info("searchRecipes()");
    return recipeService.searchRecipes(name);
  }

  @GetMapping("{id}")
  public RecipeDetailDto getRecipe(@PathVariable Long id) {
    log.info("getRecipe({})", id);
    return recipeService.getRecipe(id);
  }
}
