package org.lukabrx.recipemanagmentsystemapi.service;

import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.springframework.stereotype.Service;


@Service
public interface IRecipeService {
    long insertRecipe(RecipeDTO recipeDTO);
    RecipeDTO getRecipeById(long id);
    void deleteRecipeById(long id);
}
