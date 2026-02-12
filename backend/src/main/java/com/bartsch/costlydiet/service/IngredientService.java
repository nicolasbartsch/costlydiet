package com.bartsch.costlydiet.service;

import java.util.List;

import com.bartsch.costlydiet.model.dto.ingredient.IngredientSearchResDto;

public interface IngredientService {

  List<IngredientSearchResDto> searchIngredients(String name);

}
