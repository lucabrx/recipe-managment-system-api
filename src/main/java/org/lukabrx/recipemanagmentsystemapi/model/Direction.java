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
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DirectionID")
    private long id;
    @Column
    public String direction;

    public Direction(String direction) {
        this.direction = direction;
    }
}
