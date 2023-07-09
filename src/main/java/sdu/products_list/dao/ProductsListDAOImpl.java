package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsListDAOImpl {

    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public ProductsListDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

}
