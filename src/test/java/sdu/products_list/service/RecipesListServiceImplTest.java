package sdu.products_list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.entity.RecipesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipesListServiceImplTest {

    @Mock
    private RecipesListDAO recipesListDAO;

    @InjectMocks
    private RecipesListServiceImpl recipesListService;

    @Test
    void RecipesListService_findAll_ReturnRecipesList() {

        List<RecipesList> recipesList = Mockito.mock(List.class);

        when(recipesListDAO.findAll()).thenReturn(recipesList);

        List<RecipesListDTO> saveRecipeList = recipesListService.findAll();

        Assertions.assertNotNull(saveRecipeList);
    }

    @Test
    void RecipesListService_findById_ReturnRecipesList() throws Exception{
        RecipesList recipesList = RecipesList.builder()
                .id(1)
                .name("testName_RecipesListDAO")
                .stepList(new ArrayList<>())
                .shopList(new ArrayList<>())
                .productsListRecipes(new ArrayList<>())
                .build();

        when(recipesListDAO.findById(1)).thenReturn(
                Optional.ofNullable(recipesList));

        RecipesListDTO saveRecipesList = recipesListService.findById(1);
        Assertions.assertNotNull(saveRecipesList);
    }

    @Test
    void RecipesListService_save_ReturnRecipesList() {
        RecipesList recipesList = RecipesList.builder()
                .id(1)
                .name("testName_RecipesListDAO")
                .stepList(new ArrayList<>())
                .shopList(new ArrayList<>())
                .productsListRecipes(new ArrayList<>())
                .build();

        RecipesListDTO recipesListDTO = RecipesListDTO.builder()
                .id(1)
                .name("testName_RecipesListDAO")
                .stepList(new ArrayList<>())
                .shopListSet(new ArrayList<>())
                .productsListRecipe(new ArrayList<>())
                .build();

        when(recipesListDAO.save(Mockito.any(RecipesList.class))).thenReturn(recipesList);

        RecipesListDTO saveRecipesList = recipesListService.save(recipesListDTO);

        Assertions.assertNotNull(saveRecipesList);
    }

    @Test
    void RecipesListService_deleteById() {
        RecipesList recipesList = RecipesList.builder()
                .id(1)
                .name("testName_RecipesListDAO")
                .stepList(new ArrayList<>())
                .shopList(new ArrayList<>())
                .productsListRecipes(new ArrayList<>())
                .build();

        when(recipesListDAO.findById(1)).thenReturn(
                Optional.of(recipesList)
        );

        assertAll(() -> recipesListService.deleteById(1));

    }
}