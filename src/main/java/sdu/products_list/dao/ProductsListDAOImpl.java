package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.exception.DataBaseException;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsListDAOImpl implements ProductsListDAO {

    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public ProductsListDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductsList> findAllProducts() {

        TypedQuery<ProductsList> query = entityManager.createQuery("from ProductsList", ProductsList.class);


        List<ProductsList> productslist = query.getResultList();

        return productslist;

    }

    @Override
    public Optional<ProductsList> findById(int theId) {

        try {
            Optional<ProductsList> theProductsList = Optional.ofNullable(entityManager.find(ProductsList.class, theId));
            return theProductsList;
        } catch (IllegalArgumentException e) {
            throw new DataBaseException();
        }
    }

    @Override
    public ProductsList save(ProductsList theProducts) {

        try {
            ProductsList dbProducts = entityManager.merge(theProducts);
            return dbProducts;
        } catch (IllegalArgumentException e) {
            throw new DataBaseException();
        }
    }

    @Override
    public void deleteById(int theId) {
        try {
            Optional<ProductsList> theProductsList = Optional.ofNullable(entityManager.find(ProductsList.class, theId));

            if (theProductsList.isPresent()) {
                entityManager.remove(theProductsList.get());
            }

        } catch (IllegalArgumentException e) {

            throw new DataBaseException();

        }
    }
}
