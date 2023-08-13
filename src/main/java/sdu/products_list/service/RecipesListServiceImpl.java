package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dto.ProductsListRecipeDTO;
import sdu.products_list.dto.RecipesListShopDTO;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.dto.StepListDTO;
import sdu.products_list.entity.StepList;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                recipeListDTO.add(RecipesListDTO.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .build());
            });

        return recipeListDTO;

    }

    @Override
    public RecipesListDTO findById(int theId) {

        RecipesList productRecipe = recipesListDAO.findById(theId);

        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
                .id(productRecipe.getId())
                .name(productRecipe.getName())
                .stepList(productRecipe.getStepList().stream()
                        .map(x->StepListDTO.builder()
                        .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                                .build()).collect(Collectors.toList()))
                .recipesListShop(productRecipe.getRecipesListShops().stream()
                        .map(x-> RecipesListShopDTO.builder()
                                .id(x.getId())
                        .build()).collect(Collectors.toList()))
                .productsListRecipe(productRecipe.getProductsListRecipes().stream()
                        .map(x-> ProductsListRecipeDTO.builder()
                                .id(x.getId()).gty(x.getGty())
                        .build()).collect(Collectors.toList()))
                .build();

        return productRecipeDTO;

    }

    @Transactional
    @Override
    public RecipesListDTO save(RecipesListDTO theRecipeDTO) {

        RecipesList productRecipe = recipesListDAO.save(RecipesList.builder()
                        .id(theRecipeDTO.getId())
                        .name(theRecipeDTO.getName())
                        .stepList(theRecipeDTO.getStepList() != null ? theRecipeDTO.getStepList().stream()
                                .map(x-> StepList.builder()
                                        .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                                .build()).collect(Collectors.toList()) : null)
                        .build());

        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
                .id(productRecipe.getId())
                .name(productRecipe.getName())
                .build();

        if (productRecipe.getStepList() != null) {
            productRecipeDTO.setStepList(productRecipe.getStepList().stream()
                        .map(x->StepListDTO.builder()
                                .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                        .build()).collect(Collectors.toList()));
        }

        return productRecipeDTO;

    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        recipesListDAO.deleteById(theId);
    }
}
