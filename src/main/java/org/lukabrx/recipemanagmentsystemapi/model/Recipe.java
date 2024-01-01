package org.lukabrx.recipemanagmentsystemapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private LocalDateTime date;

    @ElementCollection
    private List<String> ingredients = new ArrayList<>();
    @ElementCollection
    private List<String> directions = new ArrayList<>();


    public Recipe(String name, String description, List<String> ingredients, List<String> directions, String category) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.category = category;
        this.date = LocalDateTime.now();
    }
}

