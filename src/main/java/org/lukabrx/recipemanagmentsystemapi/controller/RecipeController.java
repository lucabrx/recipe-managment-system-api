package org.lukabrx.recipemanagmentsystemapi.controller;

import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private Recipe currentRecipe = null;

    @PostMapping
    public ResponseEntity<String> addRecipe(@RequestBody RecipeDTO recipeDto) {
        currentRecipe = new Recipe();
        currentRecipe.setName(recipeDto.getName());
        currentRecipe.setDescription(recipeDto.getDescription());
        currentRecipe.setIngredients(recipeDto.getIngredients());
        currentRecipe.setDirections(recipeDto.getDirections());

        return ResponseEntity.ok("Recipe added successfully");
    }

    @GetMapping
    public ResponseEntity<RecipeDTO> getRecipe() {
        if (currentRecipe == null) {
            return ResponseEntity.notFound().build();
        }

        RecipeDTO recipeDto = new RecipeDTO();
        recipeDto.setName(currentRecipe.getName());
        recipeDto.setDescription(currentRecipe.getDescription());
        recipeDto.setIngredients(currentRecipe.getIngredients());
        recipeDto.setDirections(currentRecipe.getDirections());

        return ResponseEntity.ok(recipeDto);
    }
}
