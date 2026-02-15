package com.bartsch.costlydiet.repository;

import com.bartsch.costlydiet.model.entity.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%'))")
  List<Recipe> searchByNameContains(@Param("name") String name);
}
