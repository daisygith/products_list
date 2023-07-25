package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ShopListDAO;
import sdu.products_list.entity.ShopList;

import java.util.List;

@Service
public class ShopListServiceImpl implements ShopListService{

    @Autowired
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

    @Transactional
    @Override
    public ShopList save(ShopList theShopList) {
        return shopListDAO.save(theShopList);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        shopListDAO.deleteById(theId);
    }


}
