package sdu.products_list.dao;

import sdu.products_list.entity.RecipesList;

import java.util.List;
import java.util.Optional;

public interface RecipesListDAO {

    List<RecipesList> findAll();

    Optional<RecipesList> findById(int theId);

    RecipesList save(RecipesList theRecipe);

    void deleteById(int theId);

}
