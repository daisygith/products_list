package sdu.products_list.service;

import sdu.products_list.dto.ShopListDTO;


import java.util.List;

public interface ShopListService {

    List<ShopListDTO> findAll();

    ShopListDTO findById(int theId);

    ShopListDTO save(ShopListDTO theShopListDTO);

    void deleteById(int theId);

}
