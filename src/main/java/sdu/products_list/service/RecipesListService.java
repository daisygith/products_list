package sdu.products_list.service;

import sdu.products_list.entity.RecipesList;

import java.util.List;

public interface RecipesListService {
    List<RecipesList> findAll();
}
