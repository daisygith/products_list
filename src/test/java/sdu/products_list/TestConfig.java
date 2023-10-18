package sdu.products_list;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import sdu.products_list.dao.*;

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

    @Bean
    public ShopListDAO shopListDAO()  {
        return new ShopListDAOImpl(entityManager);
    }
}
