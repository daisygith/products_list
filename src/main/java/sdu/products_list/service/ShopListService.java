package sdu.products_list.service;

import sdu.products_list.entity.ShopList;

import java.util.List;

public interface ShopListService {

    List<ShopList> findAll();

    ShopList findById(int theId);

    ShopList save(ShopList theShopList);

    void deleteById(int theId);

}
