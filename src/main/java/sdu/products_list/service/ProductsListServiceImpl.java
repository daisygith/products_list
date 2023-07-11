package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.entity.ProductsList;

import java.util.List;

@Service
public class ProductsListServiceImpl implements ProductsListService{

    @Autowired
    private ProductsListDAO productsListDAO;

//    @Autowired
//    public ProductsListServiceImpl(ProductsListDAO theProductsListDAO){
//        productsListDAO = theProductsListDAO;
//    }

    @Override
    public List<ProductsList> findAllProducts(){
        return productsListDAO.findAllProducts();
    }
}
