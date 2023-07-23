package sdu.products_list.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.service.ProductsListService;
import sdu.products_list.service.RecipesListService;

import java.util.List;

@RestController
@RequestMapping("/rec")
public class RecipesListRestController {

    private RecipesListService recipesListService;

    // quick and dirty: injection employee dao(use constructor injection)
    public RecipesListRestController(RecipesListService theRecipesListService) {
        recipesListService = theRecipesListService;
    }

    // expose "/recipeslist" and return a list of employee
    @GetMapping("/recipeslist")
    public List<RecipesList> findAll(){

        return recipesListService.findAll();
        }

        // add mapping for GET /recipeslist/{recipeID}
    @GetMapping("recipeslist/{recipeId}")
    public RecipesList getRecipesList(@PathVariable int recipeId){

        RecipesList theRecipe = recipesListService.findById(recipeId);

        if(theRecipe == null){
            throw new RuntimeException("Recipe id not found - " + recipeId);
        }
        return theRecipe;
    }


}
