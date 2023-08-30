package sdu.products_list.service;

import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.entity.ProductsList;

import java.util.List;

public interface ProductsListService {

    List<ProductsListDTO> findAllProducts();

//    ProductsListDTO findById(int theId);
//
//    ProductsListDTO save(ProductsListDTO theProductsDTO);
//
//    void deleteById(int theId);

}
