package sdu.products_list.dao;

import sdu.products_list.entity.ProductsList;

import java.util.List;

public interface ProductsListDAO {

    List<ProductsList> findAllProducts();

    ProductsList findById(int theId);

    ProductsList save(ProductsList theProducts);

    void deleteById(int theId);
}
