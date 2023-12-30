package org.lukabrx.recipemanagmentsystemapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}
