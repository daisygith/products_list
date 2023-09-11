package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ShopListDAO;
import sdu.products_list.dto.ProductsListShopDTO;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ProductsListShop;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.entity.ShopList;
import sdu.products_list.exception.ElementNotFoundException;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopListServiceImpl implements ShopListService{

    @Autowired
    private ShopListDAO shopListDAO;

    @Override
    public List<ShopListDTO> findAll() {

       List<ShopList> shopList = shopListDAO.findAllShopList();

       List<ShopListDTO> shopListDTO = new ArrayList<>();

       shopList.forEach((ShopList item) -> {
           shopListDTO.add(ShopListDTO.builder()
                   .id(item.getId())
                   .name(item.getName())
                   .build());
       });

       return shopListDTO;
    }

    @Override
    public ShopListDTO findById(int theId) throws Exception{

        try {

            ShopList productShopList = shopListDAO.findById(theId);

            ShopListDTO productShopListDTO = ShopListDTO.builder()
                    .id(productShopList.getId())
                    .name(productShopList.getName())
                    .productsListShop(productShopList.getProductsListShop().stream()
                            .map(x -> ProductsListShopDTO.builder()
                                    .id(x.getId())
                                    .qty(x.getQty())
                                    .productsListId(x.getProductsList().getId())
                                    .productsListName(x.getProductsList().getName())
                                    .productsListUnit(x.getProductsList().getUnit())
                                    .build()).collect(Collectors.toList()))
                    .build();

            return productShopListDTO;
        }
        catch (NullPointerException id) {
            throw new ElementNotFoundException(theId, "ShopList");
        }

    }


    @Transactional
    @Override
    public ShopListDTO save(ShopListDTO theShopListDTO) {

        ShopList shopList1 = ShopList.builder()
                        .id(theShopListDTO.getId())
                        .name(theShopListDTO.getName())
                        .build();

        shopList1.setRecipesList(theShopListDTO.getRecipesList() != null ? theShopListDTO.getRecipesList().stream()
                                .map(x-> RecipesList.builder()
                                        .id(x.getId())
                                        .name(x.getName())
                                        .build())
                                .collect(Collectors.toList()) : null);

        shopList1.setProductsListShop(theShopListDTO.getProductsListShop() !=null ? theShopListDTO.getProductsListShop().stream()
                                .map(x-> ProductsListShop.builder()
                                        .id(x.getId())
                                        .qty(x.getQty())
                                        .shopList(shopList1)
                                        .productsList(ProductsList.builder()
                                                .id(x.getProductsListId())
                                                .name(x.getProductsListName())
                                                .unit(x.getProductsListUnit())
                                                .build())
                                        .build()).collect(Collectors.toList()) : null);

        ShopList shopList = shopListDAO.save(shopList1);

        ShopListDTO shopListDTO = ShopListDTO.builder()
                .id(shopList.getId())
                .name(shopList.getName())
                .build();

        if(shopList.getRecipesList() != null) {
            shopListDTO.setRecipesList(shopList.getRecipesList().stream()
                    .map(x->RecipesListDTO.builder()
                            .id(x.getId()).name(x.getName())
                            .build()).collect(Collectors.toList()));
        }

        if(shopList.getProductsListShop() !=null) {
            shopListDTO.setProductsListShop(shopList.getProductsListShop().stream()
                    .map(x->ProductsListShopDTO.builder()
                            .id(x.getId())
                            .qty(x.getQty())
                            .productsListId(x.getProductsList().getId())
                            .productsListName(x.getProductsList().getName())
                            .productsListUnit(x.getProductsList().getUnit())
                            .build()).collect(Collectors.toList()));
        }

        return shopListDTO;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        shopListDAO.deleteById(theId);

    }


}
