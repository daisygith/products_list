package sdu.products_list.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.service.ProductsListService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers =  ProductsListRestController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ProductsListRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductsListService productsListService;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductsList productsList;
    private ProductsListDTO productsListDTO;

    @BeforeEach
    public void init(){
         productsList = ProductsList.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO")
                .productsListRecipes(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        productsListDTO = ProductsListDTO.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO")
                .productsListRecipe(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();
    }

    @Test
    public void ProductsListRestController_findAllProducts_ReturnAll() throws Exception{

      when(productsListService.findAllProducts()).thenReturn((List<ProductsListDTO>) productsListDTO);

        ResultActions resultActions = mockMvc.perform(get("/api/productslist")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['productslist']",CoreMatchers.is((productsListDTO.getClass()))));

    }

    @Test
    void getProductsList() {
    }

    @Test
    public void  ProductsListRestController_addProducts_ReturnCreated() throws Exception {

        given(productsListService.save(ArgumentMatchers.any()))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions resultActions = mockMvc.perform(post("/api/productslist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(productsListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(productsListDTO.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$['unit']", CoreMatchers.is(productsListDTO.getUnit())));
    }

    @Test
    void updateProducts() {
    }

    @Test
    void deleteProducts() {
    }
}