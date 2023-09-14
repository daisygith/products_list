package sdu.products_list.service;

import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.exception.ElementNotFoundException;


import java.util.List;

public interface ShopListService {

    List<ShopListDTO> findAll() ;

    ShopListDTO findById(int theId) throws Exception;

    ShopListDTO save(ShopListDTO theShopListDTO);

    void deleteById(int theId);

}
