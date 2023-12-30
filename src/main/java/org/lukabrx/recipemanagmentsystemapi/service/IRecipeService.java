package org.lukabrx.recipemanagmentsystemapi.service;

import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;

import java.util.Optional;

public interface IRecipeService {
    long insertRecipe(RecipeDTO recipeDTO);
    Optional<RecipeDTO> getRecipeById(long id);
}