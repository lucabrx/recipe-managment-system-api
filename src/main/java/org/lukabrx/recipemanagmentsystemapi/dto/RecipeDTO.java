package org.lukabrx.recipemanagmentsystemapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class RecipeDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String category;

    private LocalDateTime date;

    @NotNull
    @Size(min = 1)
    private List<String> ingredients;

    @NotNull
    @Size(min = 1)
    private List<String> directions;

    public RecipeDTO(String name, String description, List<String> ingredients, List<String> directions,  String category, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.category = category;
        this.date =  date;
    }
}