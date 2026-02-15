package com.bartsch.costlydiet.service.implementation;

import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientDetailDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientSearchResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientUpdateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientUpdateResDto;
import com.bartsch.costlydiet.service.IngredientService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.bartsch.costlydiet.model.mapper.IngredientMapper;
import com.bartsch.costlydiet.repository.IngredientRepository;
import com.bartsch.costlydiet.model.entity.Ingredient;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

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

  @Override
  public List<IngredientSearchResDto> searchIngredients(String name) {
    name = name == null ? "" : name;
    return ingredientMapper.toIngredientSearchResDtoList(ingredientRepository.searchByNameContains(name));
  }

  @Override
  public IngredientDetailDto getIngredientById(Long id) {
    Ingredient ingredient = ingredientRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ingredient not found with id: " + id));

    return ingredientMapper.toIngredientDetailDto(ingredient);
  }

  @Override
  public IngredientCreateResDto addIngredient(IngredientCreateReqDto ingredientCreateReqDto) {
    log.debug("Adding ingredient {}", ingredientCreateReqDto);
    return ingredientMapper
        .toIngredientCreateResDto(ingredientRepository.save(ingredientMapper.toEntity(ingredientCreateReqDto)));
  }

  @Override
  @Transactional
  public IngredientUpdateResDto updateIngredient(Long id, IngredientUpdateReqDto dto) {
    log.debug("Updating ingredient ID {}: {}", id, dto);

    Ingredient ingredient = ingredientRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Ingredient not found with id: " + id));

    ingredient.setName(dto.getName());
    ingredient.setPrice(dto.getPrice());
    ingredient.setCalories(dto.getCalories());
    ingredient.setNotes(dto.getNotes());

    return ingredientMapper.toIngredientUpdateResDto(ingredient);
  }

}
