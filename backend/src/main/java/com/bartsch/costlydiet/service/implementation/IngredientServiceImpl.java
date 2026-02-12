package com.bartsch.costlydiet.service.implementation;

import com.bartsch.costlydiet.service.IngredientService;
import com.bartsch.costlydiet.model.mapper.IngredientMapper;
import com.bartsch.costlydiet.repository.IngredientRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

  private final IngredientRepository ingredientRepository;
  private final IngredientMapper ingredientMapper;

  public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
    this.ingredientRepository = ingredientRepository;
    this.ingredientMapper = ingredientMapper;
  }

}
