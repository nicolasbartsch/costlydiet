package com.bartsch.costlydiet.repository;

import com.bartsch.costlydiet.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
