package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.entity.ProductsList;

import java.util.List;

@Service
public class ProductsListServiceImpl implements ProductsListService{

    @Autowired
    private ProductsListDAO productsListDAO;


    @Override
    public List<ProductsList> findAllProducts(){
        return productsListDAO.findAllProducts();
    }

    @Override
    public ProductsList findById(int theId) {
        return productsListDAO.findById(theId);
    }
    @Transactional
    @Override
    public ProductsList save(ProductsList theProducts) {
        return productsListDAO.save(theProducts);
    }
}
