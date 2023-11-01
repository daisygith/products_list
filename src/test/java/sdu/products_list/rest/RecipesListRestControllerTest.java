package sdu.products_list.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.service.RecipesListService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@WebMvcTest(controllers =  RecipesListRestController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class RecipesListRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipesListService recipesListService;

    @Autowired
    private ObjectMapper objectMapper;

    private RecipesList recipesList;
    private RecipesListDTO recipesListDTO;

    @BeforeEach
    public void init(){
        recipesList = RecipesList.builder()
                .name("testName_RecipesListDAO")
                .stepList(new ArrayList<>())
                .shopList(new ArrayList<>())
                .productsListRecipes(new ArrayList<>())
                .build();

        recipesListDTO = RecipesListDTO.builder()
                .name("testName_RecipesListDTO")
                .stepList(new ArrayList<>())
                .shopListSet(new ArrayList<>())
                .productsListRecipe(new ArrayList<>())
                .build();
    }

    @Test
    public void RecipesListRestControllers_findAll_ReturnAll() throws Exception {

        List<RecipesListDTO> returnRecipesList = Arrays.asList(recipesListDTO);

        Mockito.when(recipesListService.findAll()).thenReturn(returnRecipesList);

        ResultActions resultActions = mockMvc.perform(get("/rec/recipeslist")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void RecipesListRestControllers_getRecipe_RetrunRecipesListDTO() throws Exception{
        int recipesListID = 1;
        when(recipesListService.findById(recipesListID)).thenReturn(recipesListDTO);

        ResultActions resultActions = mockMvc.perform(get("/rec/recipeslist/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipesListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(recipesListDTO.getName())));

    }

    @Test
    public void RecipesListRestControllers_addRecipe_ReturnCreated() throws Exception {

        given(recipesListService.save(ArgumentMatchers.any()))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions resultActions = mockMvc.perform(post("/rec/recipeslist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(recipesListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(recipesListDTO.getName())));

    }

    @Test
    public void RecipesListRestControllers_updateRecipe_ReturnRecipesListDTO() throws Exception{
        int recipesListID = 1;
        when(recipesListService.save(recipesListDTO)).thenReturn(recipesListDTO);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/rec/recipeslist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipesListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(recipesListDTO.getName())));

    }

    @Test
    public void RecipesListRestControllers_deleteRecipe_ReturnRecipesList() throws Exception {

        int recipesListID = 1;

        when(recipesListService.findById(recipesListID)).thenReturn(recipesListDTO);
        doNothing().when(recipesListService).deleteById(recipesListID);

        ResultActions resultActions = mockMvc.perform(delete("/rec/recipeslist/1")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

    }
}