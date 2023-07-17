package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.entity.RecipesList;

import java.util.List;

@Service
public class RecipesListServiceImpl implements RecipesListService {

    private RecipesListDAO recipesListDAO;

    @Autowired
    public RecipesListServiceImpl(RecipesListDAO theRecipesListDAO){
        recipesListDAO = theRecipesListDAO;
    }

    @Override
    public List<RecipesList> findAll() {
        return recipesListDAO.findAll();

    }
}
