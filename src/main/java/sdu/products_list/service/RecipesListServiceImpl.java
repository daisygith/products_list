package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dto.*;
import sdu.products_list.entity.ProductsListRecipe;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.dao.RecipesListDAO;
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

//        productRecipe.getRecipeListShops();
        //many-to-many
        productRecipe.getShopList();

        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
                .id(productRecipe.getId())
                .name(productRecipe.getName())
                .stepList(productRecipe.getStepList().stream()
                        .map(x->StepListDTO.builder()
                        .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                                .build()).collect(Collectors.toList()))
                .shopListSet(productRecipe.getShopList().stream()
                        .map(x-> ShopListDTO.builder()
                                .id(x.getId())
                                .name(x.getName())
                                .build()).collect(Collectors.toList()))
                .productsListRecipe(productRecipe.getProductsListRecipes().stream()
                        .map(x-> ProductsListRecipeDTO.builder()
                                .id(x.getId()).qty(x.getQty())
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
//                        .recipesListShops(theRecipeDTO.getRecipesListShop() != null ? theRecipeDTO.getRecipesListShop().stream()
//                                .map(x-> RecipesListShop.builder()
//                                        .id(x.getId())
//                                        .build()).collect(Collectors.toList()) : null)
                        .productsListRecipes(theRecipeDTO.getProductsListRecipe() != null ? theRecipeDTO.getProductsListRecipe().stream()
                                .map(x-> ProductsListRecipe.builder()
                                        .id(x.getId()).qty(x.getQty())
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

//        if(productRecipe.getRecipesListShops() != null){
//            productRecipeDTO.setRecipesListShop(productRecipe.getRecipesListShops().stream()
//                    .map(x->RecipesListShopDTO.builder()
//                            .id(x.getId())
//                            .build()).collect(Collectors.toList()));
//        }

        if(productRecipe.getProductsListRecipes() != null){
            productRecipeDTO.setProductsListRecipe(productRecipe.getProductsListRecipes().stream()
                    .map(x->ProductsListRecipeDTO.builder()
                            .id(x.getId()).qty(x.getQty())
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
