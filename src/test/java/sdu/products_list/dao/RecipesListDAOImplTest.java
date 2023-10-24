package sdu.products_list.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sdu.products_list.TestConfig;
import sdu.products_list.entity.RecipesList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Import(TestConfig.class)
class RecipesListDAOImplTest {

    @Autowired
    RecipesListDAO recipesListDAO;

    @Test
    public void RecipesListDAO_SaveAll_ReturnSaveRecipesList(){

        RecipesList recipesList = RecipesList.builder()
                .name("testName_RecipesListDAO")
                .build();

        RecipesList saveTest = recipesListDAO.save(recipesList);

        Assertions.assertNotNull(saveTest);
        Assertions.assertNotNull(saveTest.getId());

    }

    @Test
    public void RecipesListDAO_GetAll_ReturnMoreThenOneRecipesList(){

        RecipesList recipesList = RecipesList.builder()
                .name("testName_RecipesListDAO")
                .build();
        RecipesList recipesList2 = RecipesList.builder()
                .name("testName2_RecipesListDAO")
                .build();

        recipesListDAO.save(recipesList);
        recipesListDAO.save(recipesList2);

        List<RecipesList> recipesList_2 = recipesListDAO.findAll();

        Assertions.assertNotNull(recipesList_2);
        Assertions.assertEquals(2,recipesList_2.size());

    }

    @Test
    public void RecipesListDAO_FindById_ReturnRecipesList(){

        RecipesList recipesList = RecipesList.builder()
                .name("testName_RecipesListDAO")
                .build();

        RecipesList saveRecipesList = recipesListDAO.save(recipesList);

        RecipesList recipesListReturn = recipesListDAO.findById(saveRecipesList.getId()).get();

        Assertions.assertNotNull(recipesListReturn);

    }

    @Test
    public void RecipesListDAO_RecipesListDelete_ReturnRecipesListIsEmpty(){

        RecipesList recipesList = RecipesList.builder()
                .name("testName_RecipesListDAO")
                .build();

        RecipesList saveRecipesList = recipesListDAO.save(recipesList);

        recipesListDAO.deleteById(saveRecipesList.getId());

        Optional<RecipesList> recipesListReturn = recipesListDAO.findById(saveRecipesList.getId());

        Assertions.assertTrue(recipesListReturn.isEmpty());

    }



}