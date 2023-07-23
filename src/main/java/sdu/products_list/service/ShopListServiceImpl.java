package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.dao.ShopListDAO;
import sdu.products_list.entity.ShopList;

import java.util.List;

@Repository
public class ShopListServiceImpl implements ShopListService{

    private ShopListDAO shopListDAO;

    @Autowired
    public ShopListServiceImpl(ShopListDAO theShopListDAO){
        shopListDAO = theShopListDAO;
    }


    @Override
    public List<ShopList> findAll() {
        return shopListDAO.findAllShopList();
    }

    @Override
    public ShopList findById(int theId) {

        return shopListDAO.findById(theId);
    }

    @Override
    public ShopList save(ShopList theShopList) {
        return shopListDAO.save(theShopList);
    }

    @Override
    public void deleteById(int theId) {
        shopListDAO.deleteById(theId);
    }


}
