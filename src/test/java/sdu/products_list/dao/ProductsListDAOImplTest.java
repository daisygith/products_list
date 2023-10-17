package sdu.products_list.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sdu.products_list.TestConfig;
import sdu.products_list.entity.ProductsList;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Import(TestConfig.class)
class ProductsListDAOImplTest {

    @Autowired
    private ProductsListDAO productsListDAO;

    @Test
    public void ProductsListDAO_SaveAll_ReturnSaveProductsList(){

        //Arrange
        ProductsList productList = ProductsList.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO").build();

        //Act
        ProductsList saveTest = productsListDAO.save(productList);

        //Assert
        Assertions.assertNotNull(saveTest);
        Assertions.assertNotNull(saveTest.getId());

    }

    @Test
    public void ProductsListDAO_GetAll_ReturnMoreThenOneProductsList(){

        ProductsList productList = ProductsList.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO").build();
        ProductsList productList2 = ProductsList.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO").build();

        productsListDAO.save(productList);
        productsListDAO.save(productList2);

        List<ProductsList> productsList_2 = productsListDAO.findAllProducts();

        Assertions.assertNotNull(productsList_2);
        Assertions.assertEquals(2,productsList_2.size());

    }

    @Test
    public void ProductsListDAO_FindById_ReturnProductsList(){

        ProductsList productList = ProductsList.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO").build();

        productsListDAO.save(productList);


        Optional<ProductsList> productsList_2 = Optional.ofNullable(productsListDAO.findById(productList.getId())).get();

        Assertions.assertNotNull(productsList_2);

    }

    @Test
    public void ProductsListDAO_ProductListDelete_ReturnProductsListIsEmpty(){

        ProductsList productList = ProductsList.builder()
                .name("testName_ProductListDAO")
                .unit("testUnit_ProductListDAO").build();

        productsListDAO.save(productList);

        productsListDAO.deleteById(productList.getId());


        Optional<ProductsList> productsListReturn = Optional.ofNullable(productsListDAO.findById(productList.getId())).get();

        Assertions.assertTrue(productsListReturn.isEmpty());

    }

}