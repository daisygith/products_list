package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.entity.ProductsList;

import java.util.List;

@Repository
public class ProductsListDAOImpl implements ProductsListDAO{

    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public ProductsListDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductsList> findAllProducts() {

        TypedQuery<ProductsList> query = entityManager.createQuery(
                "from ProductsList", ProductsList.class);


        List<ProductsList> productslist = query.getResultList();

        return productslist;

    }

    @Override
    public ProductsList findById(int theId) {

        ProductsList theProductsList = entityManager.find(ProductsList.class, theId);

        return theProductsList;
    }

    @Override
    public ProductsList save(ProductsList theProductsList) {

        ProductsList dbProductsList = entityManager.merge(theProductsList);

        return dbProductsList;
    }
}
