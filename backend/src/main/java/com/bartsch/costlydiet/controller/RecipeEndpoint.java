package com.bartsch.costlydiet.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "api/recipes")
public class RecipeEndpoint {

  public RecipeEndpoint() {
  }

}
