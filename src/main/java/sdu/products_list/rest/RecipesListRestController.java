package sdu.products_list.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.service.ProductsListService;
import sdu.products_list.service.RecipesListService;

import java.util.List;

@RestController
@RequestMapping("/rec")
public class RecipesListRestController {

    @Autowired
    private RecipesListService recipesListService;

    // quick and dirty: injection employee dao(use constructor injection)
   // public RecipesListRestController(RecipesListService theRecipesListService) {
   //     recipesListService = theRecipesListService;
   // }

    // expose "/recipeslist" and return a list of employee
    @GetMapping("/recipeslist")
    public List<RecipesList> findAll(){

        return recipesListService.findAll();
        }

        // add mapping for GET /recipeslist/{recipeID}
    @GetMapping("recipeslist/{recipeId}")
    public RecipesList getRecipe(@PathVariable int recipeId){

        RecipesList theRecipe = recipesListService.findById(recipeId);

        if(theRecipe == null){
            throw new RuntimeException("Recipe id not found - " + recipeId);
        }
        return theRecipe;
    }

    @PostMapping("/recipeslist")
    public RecipesList addRecipe(@RequestBody RecipesList theRecipe){

        theRecipe.setId(0);

        RecipesList dbRecipe = recipesListService.save(theRecipe);

        return dbRecipe;

    }

    @PutMapping("/recipeslist")
    public RecipesList updateRecipe(@RequestBody RecipesList theRecipe){

        RecipesList dbRecipe = recipesListService.save(theRecipe);

        return dbRecipe;

    }

    @DeleteMapping("/recipeslist/{recipeId}")
    public String deleteRecipe(@PathVariable int recipeId){

        RecipesList tempRecipe = recipesListService.findById(recipeId);

        if(tempRecipe == null){
            throw new RuntimeException("Recipe is not found " + recipeId);
        }
        recipesListService.deleteById(recipeId);

        return "delete recipe by id " + recipeId;

    }

}
