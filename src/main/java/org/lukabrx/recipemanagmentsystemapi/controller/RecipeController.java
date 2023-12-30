package org.lukabrx.recipemanagmentsystemapi.controller;


import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.service.IRecipeService;
import org.lukabrx.recipemanagmentsystemapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final IRecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> addRecipe(@RequestBody RecipeDTO recipeDTO) {
        long id = recipeService.insertRecipe(recipeDTO);
        return ResponseEntity.ok(Map.of("id", id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipeById(@PathVariable long id) {
        Optional<RecipeDTO> recipe = recipeService.getRecipeById(id);
        if (recipe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}