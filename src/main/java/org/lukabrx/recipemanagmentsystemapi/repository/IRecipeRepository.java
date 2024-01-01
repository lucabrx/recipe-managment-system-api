package org.lukabrx.recipemanagmentsystemapi.repository;

import org.lukabrx.recipemanagmentsystemapi.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecipeRepository  extends JpaRepository<Recipe,Long> {
    List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);
    List<Recipe> findAllByNameContainsIgnoreCaseOrderByDateDesc(String name);

}
