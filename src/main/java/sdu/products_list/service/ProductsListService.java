package sdu.products_list.service;

import sdu.products_list.entity.ProductsList;

import java.util.List;

public interface ProductsListService {

    List<ProductsList> findAllProducts();

}
