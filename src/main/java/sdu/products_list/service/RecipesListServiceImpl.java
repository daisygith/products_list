package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.RecipesListDAO;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.dto.StepListDTO;
import sdu.products_list.entity.RecipesList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipesListServiceImpl implements RecipesListService {

    @Autowired
    private RecipesListDAO recipesListDAO;

    @Override
    public List<RecipesListDTO> findAll() {
        // pobieramy liste ze wszystkimi elementami baz danych
        List<RecipesList> recipeList = recipesListDAO.findAll();
        //utworzenie pustej listy DTO
        List<RecipesListDTO> recipeListDTO = new ArrayList<>();
        //przepisanie wartosci z encji do DTO
        //recipeList.forEach((RecipesList item) -> {
//            recipeListDTO.add(new RecipesListDTO(item.getId(), item.getName(),
//                    StepListDTO // new RecipesListDTO.builder().build() - mozna to przerobić tak jak jest StepList()
//                            .builder()
//                            .id(item.getStepList().getId())
//                            .stepNr(item.getStepList().getStepNr())
//                            .description(item.getStepList().getDescription())
//                            .build()));
            recipeList.forEach((RecipesList item) -> {
                recipeListDTO.add(RecipesListDTO.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .build());
            });

        //});

        return recipeListDTO;

    }

    @Override
    public RecipesListDTO findById(int theId) {

        RecipesList productRecipe = recipesListDAO.findById(theId);

        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
                .id(productRecipe.getId())
                .name(productRecipe.getName())
                .stepList(productRecipe.getStepList().stream()
                        .map(x->StepListDTO.builder()
                        .id(x.getId()).stepNr(x.getStepNr()).description(x.getDescription())
                                .build()).collect(Collectors.toList()))
                .build();

        return productRecipeDTO;

    }
//
//    @Transactional
//    @Override
//    public RecipesListDTO save(RecipesListDTO theRecipeDTO) {
//
////        RecipesList productRecipe = recipesListDAO.save(new RecipesList(theRecipeDTO.getId(), theRecipeDTO.getName()));
////
////        RecipesListDTO productRecipeDTO = new RecipesListDTO(productRecipe.getId(), productRecipe.getName());
//
//        RecipesList productRecipe = recipesListDAO.save(RecipesList.builder()
//                        .id(theRecipeDTO.getId())
//                        .name(theRecipeDTO.getName())
//                        .build());
//
//        RecipesListDTO productRecipeDTO = RecipesListDTO.builder()
//                .id(productRecipe.getId())
//                .name(productRecipe.getName())
//                .build();
//
//        return productRecipeDTO;
//
//    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        recipesListDAO.deleteById(theId);
    }
}
