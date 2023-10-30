package sdu.products_list.service;

import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sdu.products_list.dao.ShopListDAO;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.entity.ShopList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShopListServiceImplTest {
    @Mock
    private ShopListDAO shopListDAO;

    @InjectMocks
    private ShopListServiceImpl shopListService;

    @Test
    public void ShopListService_findAll_ReturnShopList() {

        List<ShopList> shopList = Mockito.mock(List.class);
        when(shopListDAO.findAllShopList()).thenReturn(shopList);

        List<ShopListDTO> saveShopList = shopListService.findAll();
        Assertions.assertNotNull(saveShopList);

    }

    @Test
    public void ShopListService_findById_ReturnShopList() throws Exception{
        ShopList shopList = ShopList.builder()
                .id(1)
                .name("testName_ShopListDAO")
                .recipesList(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        when(shopListDAO.findById(1)).thenReturn(shopList);

        ShopListDTO saveShopList = shopListService.findById(1);
        Assertions.assertNotNull(saveShopList);

    }

    @Test
    public void ShopListService_save_ReturnShopList() {
        ShopList shopList = ShopList.builder()
                .id(1)
                .name("testName_ShopListDAO")
                .recipesList(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        ShopListDTO shopListDTO = ShopListDTO.builder()
                .id(1)
                .name("testName_ShopListDTO")
                .recipesList(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        when(shopListDAO.save(Mockito.any(ShopList.class))).thenReturn(shopList);

        ShopListDTO saveShopList = shopListService.save(shopListDTO);

        Assertions.assertNotNull(saveShopList);
    }

    @Test
    public void ShopListService_deleteById() {
        ShopList shopList = ShopList.builder()
                .id(1)
                .name("testName_ShopListDAO")
                .recipesList(new ArrayList<>())
                .productsListShop(new ArrayList<>())
                .build();

        assertAll(() -> shopListService.deleteById(1));
    }
}