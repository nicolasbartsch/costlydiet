package com.bartsch.costlydiet.repository;

import com.bartsch.costlydiet.model.entity.Ingredient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

  @Query("SELECT i FROM Ingredient i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))")
  List<Ingredient> searchByNameContains(@Param("name") String name);
}
