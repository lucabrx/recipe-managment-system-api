package org.lukabrx.recipemanagmentsystemapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public long id;
    @Column
    public String ingredient;

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

