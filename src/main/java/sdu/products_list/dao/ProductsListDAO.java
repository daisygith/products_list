package sdu.products_list.dao;

import sdu.products_list.entity.ProductsList;

import java.util.List;
import java.util.Optional;

public interface ProductsListDAO {

    List<ProductsList> findAllProducts();

    Optional<ProductsList> findById(int theId);

    ProductsList save(ProductsList theProducts);

    void deleteById(int theId);
}
