package org.lukabrx.recipemanagmentsystemapi.dto;

import lombok.Data;

@Data
public class RecipeDTO {
    private String name;
    private String description;
    private String ingredients;
    private String directions;
}
