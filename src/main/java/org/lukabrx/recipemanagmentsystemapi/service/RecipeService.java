package org.lukabrx.recipemanagmentsystemapi.service;

import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RecipeService implements IRecipeService {
    private final Map<Long, Recipe> recipes = new ConcurrentHashMap<>();
    private long currentId = 1;

    @Override
    public long insertRecipe(RecipeDTO recipeDTO) {
        long id = currentId++;
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setDirections(recipeDTO.getDirections());
        recipes.put(id, recipe);

        return id;
    }

    @Override
    public Optional<RecipeDTO> getRecipeById(long id) {
        Recipe recipe = recipes.get(id);
        if (recipe == null) {
            return Optional.empty();
        }

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setName(recipe.getName());
        recipeDTO.setDescription(recipe.getDescription());
        recipeDTO.setIngredients(recipe.getIngredients());
        recipeDTO.setDirections(recipe.getDirections());

        return Optional.of(recipeDTO);
    }
}
