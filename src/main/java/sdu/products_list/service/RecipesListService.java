package sdu.products_list.service;

import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.entity.RecipesList;

import java.util.List;

public interface RecipesListService {
    List<RecipesListDTO> findAll();

    RecipesListDTO findById(int theId);

    RecipesListDTO save(RecipesListDTO theRecipeDTO);

    void deleteById(int theId);
}
