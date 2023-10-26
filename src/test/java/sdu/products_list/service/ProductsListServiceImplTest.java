package sdu.products_list.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.entity.ProductsList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsListServiceImplTest {

    @Mock
    private ProductsListDAO productsListDAO;

    @InjectMocks
    private ProductsListServiceImpl productsListService;

    @Test
    public void ProductsList_CreateProduct_ReturnProductsListDTO(){

        ProductsList productsList = ProductsList.builder()
                .name("testName_ProductListDTO")
                .unit("testUnit_ProductListDTO")
                .build();

        ProductsListDTO productsListDTO = ProductsListDTO.builder()
                .name("testName_ProductListDTO")
                .unit("testUnit_ProductListDTO")
                .build();

        when(productsListDAO.save(Mockito.any(ProductsList.class))).thenReturn(productsList);



    }

}