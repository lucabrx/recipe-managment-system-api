package org.lukabrx.recipemanagmentsystemapi.service;

import org.lukabrx.recipemanagmentsystemapi.Utils;
import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.model.Recipe;
import org.lukabrx.recipemanagmentsystemapi.repository.IRecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
                recipeDTO.getDirections(),
                recipeDTO.getCategory());
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

    @Override
    public List<RecipeDTO> searchRecipesByCategory(String category) {
        List<Recipe> recipes = recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
        return recipes.stream().map(Utils::mapToRequest).toList();
    }

    @Override
    public List<RecipeDTO> searchRecipesByName(String name) {
        List<Recipe> recipes = recipeRepository.findAllByNameContainsIgnoreCaseOrderByDateDesc(name);
        return recipes.stream().map(Utils::mapToRequest).toList();
    }


    @Override
    public void updateRecipeById(long id, RecipeDTO request) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            Recipe recipeModel = recipe.get();
            recipeModel.setName(request.getName());
            recipeModel.setCategory(request.getCategory());
            recipeModel.setDescription(request.getDescription());
            recipeModel.setDate(LocalDateTime.now());
            recipeModel.setDirections(request.getDirections());
            recipeModel.setIngredients(request.getIngredients());
            recipeRepository.save(recipeModel);
        }
    }

}

