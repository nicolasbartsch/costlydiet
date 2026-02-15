package com.bartsch.costlydiet.service;

import java.util.List;

import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientDetailDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientSearchResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientUpdateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientUpdateResDto;

public interface IngredientService {

  List<IngredientSearchResDto> searchIngredients(String name);

  IngredientDetailDto getIngredientById(Long id);

  IngredientCreateResDto addIngredient(IngredientCreateReqDto ingredientCreateReqDto);

  IngredientUpdateResDto updateIngredient(Long id, IngredientUpdateReqDto ingredientUpdateReqDto);

}
