package sdu.products_list.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.exception.DataBaseException;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipesListDAOImpl implements RecipesListDAO {

    //define fields for entitymanager
    private EntityManager entityManager;

    int theRecipe;

    // set up constructor injuction
    @Autowired
    public RecipesListDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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
    public Optional<RecipesList> findById(int theId) {

        try {
            // get recipe
            Optional<RecipesList> theRecipe = Optional.ofNullable(entityManager.find(RecipesList.class, theId));

            return theRecipe;

        } catch (IllegalArgumentException e) {

            throw new DataBaseException();
        }
    }

    @Override
    public RecipesList save(RecipesList theRecipe) {

        try {
            RecipesList dbRecipe = entityManager.merge(theRecipe);

            return dbRecipe;
        } catch (IllegalArgumentException e) {

            throw new DataBaseException();
        }
    }

    @Override
    public void deleteById(int theId) {

        try {
            Optional<RecipesList> theRecipe = Optional.ofNullable(entityManager.find(RecipesList.class, theId));

            if (theRecipe.isPresent()) {

                entityManager.remove(theRecipe.get());
            }
        } catch (IllegalArgumentException e) {

            throw new DataBaseException();

        }
    }
}


