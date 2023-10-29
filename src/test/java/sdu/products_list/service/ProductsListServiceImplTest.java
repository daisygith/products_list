package sdu.products_list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ProductsListRecipe;
import sdu.products_list.entity.ProductsListShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsListServiceImplTest {

    @Mock
    private ProductsListDAO productsListDAO;

    @InjectMocks
    private ProductsListServiceImpl productsListService;

    @Test
    public void ProductsListService_findAllProducts_ReturnsResponseDTO(){

        List<ProductsList> productsList = Mockito.mock(List.class);

        when(productsListDAO.findAllProducts()).thenReturn(productsList);

        List<ProductsListDTO> saveProductsList = productsListService.findAllProducts();

        Assertions.assertNotNull(saveProductsList);

    }

    @Test
    public void ProductsListService_findById_ReturnsProductsListDTO() throws Exception {

        ProductsList productList = ProductsList.builder()
                .id(1)
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO")
                .productsListRecipes(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        when(productsListDAO.findById(1))
                .thenReturn(Optional.ofNullable(productList));

        ProductsListDTO saveProductsList = productsListService.findById(1);

        Assertions.assertNotNull(saveProductsList);
    }

    @Test
    public void ProductsListService_save_ReturnProductsListDTO(){

        ProductsList productList = ProductsList.builder()
                .id(1)
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO")
                .productsListRecipes(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        ProductsListDTO productListDTO = ProductsListDTO.builder()
                .id(1)
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO")
                .productsListRecipe(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

       // when(productsListDAO.findById(1)).thenReturn(Optional.ofNullable(productList));
        when(productsListDAO.save(Mockito.any(ProductsList.class))).thenReturn(productList);

        ProductsListDTO saveProductsList = productsListService.save(productListDTO);

        Assertions.assertNotNull(saveProductsList);

    }

    @Test
    public void ProductsListService_deleteById_ReturnProductsList(){
        ProductsList productList = ProductsList.builder()
                .id(1)
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO")
                .productsListRecipes(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

      //  when(productsListDAO.findById(1)).thenReturn(Optional.ofNullable(productList));

        assertAll(() -> productsListService.deleteById(1));

    }

}