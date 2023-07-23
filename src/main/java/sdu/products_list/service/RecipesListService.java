package sdu.products_list.service;

import sdu.products_list.entity.RecipesList;

import java.util.List;

public interface RecipesListService {
    List<RecipesList> findAll();

    RecipesList findById(int theId);

    RecipesList save(RecipesList theRecipe);

    void deleteById(int theId);
}
