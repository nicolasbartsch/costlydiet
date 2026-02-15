package com.bartsch.costlydiet.repository;

import com.bartsch.costlydiet.model.entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {

}
