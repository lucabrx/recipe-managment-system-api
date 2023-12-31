package org.lukabrx.recipemanagmentsystemapi.service;

import org.lukabrx.recipemanagmentsystemapi.Utils;
import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.model.Recipe;
import org.lukabrx.recipemanagmentsystemapi.repository.IRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RecipeService implements IRecipeService {

    private final IRecipeRepository recipeRepository;

    public RecipeService(IRecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public long insertRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe(
                recipeDTO.getName(),
                recipeDTO.getDescription(),
                recipeDTO.getIngredients(),
                recipeDTO.getDirections());
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    @Override
    public RecipeDTO getRecipeById(long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.map(Utils::mapToRequest).orElse(null);
    }

    @Override
    public void deleteRecipeById(long id) {
        recipeRepository.deleteById(id);
    }
}

