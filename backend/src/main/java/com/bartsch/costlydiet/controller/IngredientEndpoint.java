package com.bartsch.costlydiet.controller;

import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientDetailDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientSearchResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientUpdateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientUpdateResDto;
import com.bartsch.costlydiet.service.IngredientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/ingredients")
public class IngredientEndpoint {

  private final IngredientService ingredientService;

  public IngredientEndpoint(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping()
  public List<IngredientSearchResDto> searchIngredients(@RequestParam(required = false) String name) {
    log.info("getIngredients()");
    return ingredientService.searchIngredients(name);
  }

  @GetMapping("/{id}")
  public IngredientDetailDto getIngredientById(@PathVariable Long id) {
    log.info("getIngredient with id {id}", id);
    return ingredientService.getIngredientById(id);
  }

  @PostMapping()
  public IngredientCreateResDto addIngredient(@RequestBody IngredientCreateReqDto ingredientCreateReqDto) {
    log.info("addIngredient({})", ingredientCreateReqDto);
    return ingredientService.addIngredient(ingredientCreateReqDto);
  }

  @PutMapping("/{id}")
  public IngredientUpdateResDto updateIngredient(@PathVariable Long id,
      @RequestBody IngredientUpdateReqDto ingredientUpdateReqDto) {
    log.info("updateIngredient({})", ingredientUpdateReqDto);
    return ingredientService.updateIngredient(id, ingredientUpdateReqDto);
  }

}
