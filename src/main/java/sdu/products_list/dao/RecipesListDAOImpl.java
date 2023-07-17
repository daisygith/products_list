package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import sdu.products_list.entity.RecipesList;

import java.util.List;

public class RecipesListDAOImpl implements RecipesListDAO{

    //define fields for entitymanager
    private EntityManager entityManager;

    // set up constructor injuction
    @Autowired
    public RecipesListDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<RecipesList> findAll() {

        // create a query
        TypedQuery<RecipesList> theQuery = entityManager.createQuery(
                "from RecipesList", RecipesList.class);

        //execute query and get result list
        List<RecipesList> recipesLists = theQuery.getResultList();

        //return the results
        return recipesLists;
    }
}
