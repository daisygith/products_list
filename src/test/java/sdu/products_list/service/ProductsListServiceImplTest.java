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
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO").build();

        when(productsListDAO.findById(1)).thenReturn(Optional.ofNullable(productList));

        ProductsListDTO saveProductsList = productsListService.findById(1);

        Assertions.assertNotNull(saveProductsList);




    }

}