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
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ShopList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Import(TestConfig.class)
class ShopListDAOImplTest {

    @Autowired
    private ShopListDAO shopListDAO;

    @Test
    public void ShopListDAO_SaveAll_ReturnSaveShopList(){

        ShopList shopList = ShopList.builder()
                .name("testName_ShopListDAO")
                .build();

        ShopList saveTest = shopListDAO.save(shopList);

        Assertions.assertNotNull(saveTest);
        Assertions.assertNotNull(saveTest.getId());

    }

    @Test
    public void ShopListDAO_GetAll_ReturnMoreThanOneShopList(){

        ShopList shopList = ShopList.builder()
                .name("testName_ShopListDAO")
                .build();

        ShopList shopList2 = ShopList.builder()
                .name("testName2_ShopListDAO")
                .build();

        shopListDAO.save(shopList);
        shopListDAO.save(shopList2);

        List<ShopList> shopList_2 = shopListDAO.findAllShopList();

        Assertions.assertNotNull(shopList_2);
        Assertions.assertEquals(2,shopList_2.size());
    }

//    @Test
//    public void ShopListDAO_FindById_ReturnShopList() throws Exception {
//
//        ShopList shopList = ShopList.builder()
//                .name("testName_ShopListDAO")
//                .build();
//
//        shopListDAO.save(shopList);
//
//        ShopList shopListReturn = shopListDAO.findById(shopList.getId());
//
//        //Assertions.assertNotNull(shopListReturn);
//
//    }

}