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
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.entity.ShopList;
import sdu.products_list.service.ShopListService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@WebMvcTest(controllers =  ShopListRestController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ShopListRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShopListService shopListService;

    @Autowired
    private ObjectMapper objectMapper;

    private ShopList shopList;
    private ShopListDTO shopListDTO;

    @BeforeEach
    public void init(){
        shopList = ShopList.builder()
                .name("testNAme_ShopListDAO")
                .recipesList(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        shopListDTO = ShopListDTO.builder()
                .name("testName_ShopListDTO")
                //.recipesList(new ArrayList<>())
                //.shopList(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();
    }

    @Test
    public void RecipesListRestController_findAll_ReturnAll() throws Exception{

        List<ShopListDTO> returnShopList = Arrays.asList(shopListDTO);

        Mockito.when(shopListService.findAll()).thenReturn(returnShopList);

        ResultActions resultActions = mockMvc.perform(get("/shop/shoplist")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void RecipesListRestController_getShopList_ReturnShopListDTO() throws Exception{
        int shopListID = 1;

        when(shopListService.findById(shopListID)).thenReturn(shopListDTO);

        ResultActions resultActions = mockMvc.perform(get("/shop/shoplist/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shopListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(shopListDTO.getName())));
    }

    @Test
    public void ShopListRestController_addShopList_ReturnCreated() throws Exception{
        given(shopListService.save(ArgumentMatchers.any()))
                .willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions resultActions = mockMvc.perform(post("/shop/shoplist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(shopListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(shopListDTO.getName())));
    }

    @Test
    public void ShopListRestController_updateShopList_ReturnProductsListDTO() throws Exception {
        int shopListID = 1;

        when(shopListService.save(shopListDTO)).thenReturn(shopListDTO);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/shop/shoplist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shopListDTO)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$['name']", CoreMatchers.is(shopListDTO.getName())));
    }

    @Test
    public void ShopListRestController_deleteShopList_ReturnShopList() throws Exception {
        int shopListID = 1;

        when(shopListService.findById(shopListID)).thenReturn(shopListDTO);
        doNothing().when(shopListService).deleteById(shopListID);

        ResultActions resultActions = mockMvc.perform(delete("/shop/shoplist/1")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }
}