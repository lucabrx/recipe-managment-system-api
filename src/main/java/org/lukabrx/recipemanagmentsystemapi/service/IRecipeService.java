package org.lukabrx.recipemanagmentsystemapi.service;

import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IRecipeService {
    long insertRecipe(RecipeDTO recipeDTO);
    RecipeDTO getRecipeById(long id);
    void deleteRecipeById(long id);

    List<RecipeDTO> searchRecipesByCategory(String category);

    List<RecipeDTO> searchRecipesByName(String name);

    void updateRecipeById(long id, RecipeDTO recipeRequest);
}
