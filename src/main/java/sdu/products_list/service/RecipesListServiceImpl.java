package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.entity.RecipesList;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipesListServiceImpl implements RecipesListService {

    @Autowired
    private RecipesListDAO recipesListDAO;

    @Override
    public List<RecipesListDTO> findAll() {
        // pobieramy liste ze wszystkimi elementami baz danych
        List<RecipesList> recipeList = recipesListDAO.findAll();
        //utworzenie pustej listy DTO
        List<RecipesListDTO> recipeListDTO = new ArrayList<>();
        //przepisanie wartosci z encji do DTO
        recipeList.forEach((RecipesList item) -> {
            recipeListDTO.add(new RecipesListDTO(item.getId(), item.getName()));
        });

        return recipeListDTO;

    }

    @Override
    public RecipesListDTO findById(int theId) {

        RecipesList productRecipe = recipesListDAO.findById(theId);

        RecipesListDTO productRecipeDTO = new RecipesListDTO(productRecipe.getId(), productRecipe.getName());

        return productRecipeDTO;

    }

    @Transactional
    @Override
    public RecipesListDTO save(RecipesListDTO theRecipeDTO) {

        RecipesList productRecipe = recipesListDAO.save(new RecipesList(theRecipeDTO.getId(), theRecipeDTO.getName()));

        RecipesListDTO productRecipeDTO = new RecipesListDTO(productRecipe.getId(), productRecipe.getName());

        return productRecipeDTO;

    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        recipesListDAO.deleteById(theId);
    }
}
