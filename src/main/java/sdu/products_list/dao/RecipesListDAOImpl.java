package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.entity.RecipesList;

import java.util.List;

@Repository
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

    @Override
    public RecipesList findById(int theId) {

        // get recipe
        RecipesList theRecipe = entityManager.find(RecipesList.class, theId);

        return theRecipe;
    }

    @Override
    public RecipesList save(RecipesList theRecipe) {

        RecipesList dbRecipe = entityManager.merge(theRecipe);

        return dbRecipe;
    }

    @Override
    public void deleteById(int theId) {
        RecipesList theRecipe = entityManager.find(RecipesList.class, theId);

        entityManager.remove(theRecipe);
    }
}
