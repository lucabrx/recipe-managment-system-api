package org.lukabrx.recipemanagmentsystemapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}

