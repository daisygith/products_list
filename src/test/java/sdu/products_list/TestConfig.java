package sdu.products_list;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.dao.ProductsListDAOImpl;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.dao.RecipesListDAOImpl;

@TestConfiguration
public class TestConfig {
    @Autowired
    EntityManager entityManager;
    @Bean
    public ProductsListDAO productsListDAO()  {
        return new ProductsListDAOImpl(entityManager);
    }

    @Bean
    public RecipesListDAO recipesListDAO()  {
        return new RecipesListDAOImpl(entityManager);
    }
}
