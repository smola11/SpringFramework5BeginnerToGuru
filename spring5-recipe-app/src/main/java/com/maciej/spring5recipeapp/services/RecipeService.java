package com.maciej.spring5recipeapp.services;

import com.maciej.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
