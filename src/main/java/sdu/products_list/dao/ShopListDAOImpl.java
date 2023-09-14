package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.entity.ShopList;
import sdu.products_list.exception.DataBaseException;

import java.util.List;

@Repository
public class ShopListDAOImpl implements ShopListDAO {


    private EntityManager entityManager;

    @Autowired
    public ShopListDAOImpl(EntityManager entityManager) {
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
    public ShopList findById(int theId) throws Exception {

        try {
            ShopList theShopList = entityManager.find(ShopList.class, theId);

            return theShopList;

        } catch (IllegalArgumentException e) {
            throw new DataBaseException();
        }
    }


    @Override
    public ShopList save(ShopList theShopList) {

        try {

            ShopList dbShopList = entityManager.merge(theShopList);

            return dbShopList;

        } catch (IllegalArgumentException e) {
            throw new DataBaseException();
        }
    }

    @Override
    public void deleteById(int theId) {

        try {
            // najpierw znaleźć
            ShopList theShopList = entityManager.find(ShopList.class, theId);

            entityManager.remove(theShopList);

        } catch (IllegalArgumentException e) {
            throw new DataBaseException();
        }
    }


}
