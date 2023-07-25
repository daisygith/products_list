package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.entity.RecipesList;

import java.util.List;

@Service
public class RecipesListServiceImpl implements RecipesListService {

    @Autowired
    private RecipesListDAO recipesListDAO;

    @Autowired
    public RecipesListServiceImpl(RecipesListDAO theRecipesListDAO){
        recipesListDAO = theRecipesListDAO;
    }

    @Override
    public List<RecipesList> findAll() {
        return recipesListDAO.findAll();

    }

    @Override
    public RecipesList findById(int theId) {

        return recipesListDAO.findById(theId);

    }

    @Transactional
    @Override
    public RecipesList save(RecipesList theRecipe) {

        return recipesListDAO.save(theRecipe);

    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        recipesListDAO.deleteById(theId);
    }
}
