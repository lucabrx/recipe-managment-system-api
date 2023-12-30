package org.lukabrx.recipemanagmentsystemapi.repository;

import org.lukabrx.recipemanagmentsystemapi.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository  extends JpaRepository<Recipe,Long> {
}
