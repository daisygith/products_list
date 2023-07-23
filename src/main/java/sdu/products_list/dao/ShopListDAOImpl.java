package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ShopList;

import java.util.List;

@Repository
public class ShopListDAOImpl implements ShopListDAO{

    private EntityManager entityManager;

    @Autowired
    public ShopListDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ShopList> findAllShopList() {

        // stworzyć zapytanie
        TypedQuery<ShopList> query = entityManager.createQuery("from ShopList", ShopList.class);


        List<ShopList> shopList = query.getResultList();

        return shopList;
    }

    @Override
    public ShopList findById(int theId) {

        ShopList theShopList = entityManager.find(ShopList.class, theId);

        return theShopList;
    }

    @Override
    public ShopList save(ShopList theShopList) {

        ShopList dbShopList = entityManager.merge(theShopList);

        return dbShopList;
    }

    @Override
    public void deleteById(int theId) {

        // najpierw znaleźć
        ShopList theShopList = entityManager.find(ShopList.class, theId);

        entityManager.remove(theShopList);
    }


}
