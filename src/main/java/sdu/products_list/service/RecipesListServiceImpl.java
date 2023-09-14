package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dto.*;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ProductsListRecipe;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.entity.StepList;
import sdu.products_list.exception.ElementNotFoundException;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipesListServiceImpl implements RecipesListService {

    @Autowired
    private RecipesListDAO recipesListDAO;

    @Override
    public List<RecipesListDTO> findAll() {

        List<RecipesList> recipeList = recipesListDAO.findAll();

        List<RecipesListDTO> recipeListDTO = new ArrayList<>();

        recipeList.forEach((RecipesList item) -> {
            recipeListDTO.add(RecipesListDTO.builder()
                    .id(item.getId())
                    .name(item.getName())
                    .build());
        });

        return recipeListDTO;

    }

    @Override
    public RecipesListDTO findById(int theId) throws Exception {

        RecipesList productRecipe = recipesListDAO.findById(theId).orElseThrow(() -> new ElementNotFoundException(
                theId, "RecipesList"));

        productRecipe.getShopList();

        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
                .id(productRecipe.getId())
                .name(productRecipe.getName())
                .stepList(productRecipe.getStepList().stream()
                        .map(x -> StepListDTO.builder()
                                .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                                .build()).collect(Collectors.toList()))
                .productsListRecipe(productRecipe.getProductsListRecipes().stream()
                        .map(x -> ProductsListRecipeDTO.builder()
                                .id(x.getId())
                                .qty(x.getQty())
                                .productsListId(x.getProductsList().getId())
                                .productsListName(x.getProductsList().getName())
                                .productsListUnit(x.getProductsList().getUnit())
                                .build()).collect(Collectors.toList()))
                .build();

        return productRecipeDTO;

    }

    @Transactional
    @Override
    public RecipesListDTO save(RecipesListDTO theRecipeDTO) {

        RecipesList productRecipe1 = RecipesList.builder()
                .id(theRecipeDTO.getId())
                .name(theRecipeDTO.getName())
                .build();

        productRecipe1.setStepList(theRecipeDTO.getStepList() != null ? theRecipeDTO.getStepList().stream()
                .map(x -> StepList.builder()
                        .id(x.getId())
                        .stepNr(x.getStepNr())
                        .description(x.getDescription())
                        .recipesList(productRecipe1)
                        .build())
                .collect(Collectors.toList()) : null);
        productRecipe1.setProductsListRecipes(theRecipeDTO.getProductsListRecipe() != null ? theRecipeDTO.getProductsListRecipe().stream()
                .map(x -> ProductsListRecipe.builder()
                        .id(x.getId())
                        .qty(x.getQty())
                        .recipesList(productRecipe1)
                        .productsList(ProductsList.builder()
                                .id(x.getProductsListId())
                                .name(x.getProductsListName())
                                .unit(x.getProductsListUnit())
                                .build())
                        .build()).collect(Collectors.toList()) : null);

        RecipesList productRecipe = recipesListDAO.save(productRecipe1);

        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
                .id(productRecipe.getId())
                .name(productRecipe.getName())
                .build();

        if (productRecipe.getStepList() != null) {
            productRecipeDTO.setStepList(productRecipe.getStepList().stream()
                    .map(x -> StepListDTO.builder()
                            .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                            .build()).collect(Collectors.toList()));
        }


        if (productRecipe.getProductsListRecipes() != null) {
            productRecipeDTO.setProductsListRecipe(productRecipe.getProductsListRecipes().stream()
                    .map(x -> ProductsListRecipeDTO.builder()
                            .id(x.getId())
                            .qty(x.getQty())
                            .productsListId(x.getProductsList().getId())
                            .productsListName(x.getProductsList().getName())
                            .productsListUnit(x.getProductsList().getUnit())
                            .build()).collect(Collectors.toList()));
        }

        return productRecipeDTO;

    }

    @Transactional
    @Override
    public void deleteById(int theId){

        recipesListDAO.deleteById(theId);
    }
}
