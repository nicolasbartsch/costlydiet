package com.bartsch.costlydiet.model.mapper;

import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateReqDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientCreateResDto;
import com.bartsch.costlydiet.model.dto.ingredient.IngredientSearchResDto;
import com.bartsch.costlydiet.model.entity.Ingredient;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

  Ingredient toEntity(IngredientCreateReqDto ingredientCreateReqDto);

  IngredientSearchResDto toIngredientSearchResDto(Ingredient ingredient);

  List<IngredientSearchResDto> toIngredientSearchResDtoList(List<Ingredient> ingredients);

  IngredientCreateResDto toIngredientCreateResDto(Ingredient ingredient);
}
