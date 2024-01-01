package org.lukabrx.recipemanagmentsystemapi;

import org.lukabrx.recipemanagmentsystemapi.dto.RecipeDTO;
import org.lukabrx.recipemanagmentsystemapi.model.Recipe;

public class Utils {
    public static RecipeDTO mapToRequest(Recipe recipe) {
        return new RecipeDTO(
                recipe.getName(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections(),
                recipe.getCategory(),
                recipe.getDate()
        );
    }
}
