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
    public void ProductListDAO_SaveAll_ReturnSaveProduct(){

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

//    @Test
//    void findById() {
//        var findID = new ProductsList();
//        assertNotNull(findID.getId());
//    }
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void deleteById() {
//    }
}