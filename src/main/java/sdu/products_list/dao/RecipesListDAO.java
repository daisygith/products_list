package sdu.products_list.dao;

import sdu.products_list.entity.RecipesList;

import java.util.List;

public interface RecipesListDAO {

    List<RecipesList> findAll();

}
