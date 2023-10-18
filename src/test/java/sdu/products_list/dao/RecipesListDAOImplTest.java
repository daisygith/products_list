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





}