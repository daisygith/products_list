package sdu.products_list.service;

import sdu.products_list.dto.RecipesListDTO;


import java.util.List;

public interface RecipesListService {
    List<RecipesListDTO> findAll();

    RecipesListDTO findById(int theId) throws Exception;

    RecipesListDTO save(RecipesListDTO theRecipeDTO);

    void deleteById(int theId);
}
