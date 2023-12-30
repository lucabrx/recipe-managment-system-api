package org.lukabrx.recipemanagmentsystemapi.controller;


import jakarta.validation.Valid;
import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> postRecipe(@RequestBody @Valid RecipeDTO request) {
        long id = recipeService.insertRecipe(request);
        return new ResponseEntity<>(Map.of("id", id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable long id) {
        RecipeDTO recipeDTO = recipeService.getRecipeById(id);
        if (recipeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipeDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable long id) {
        if (recipeService.getRecipeById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
