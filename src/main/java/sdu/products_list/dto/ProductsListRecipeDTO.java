package sdu.products_list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sdu.products_list.entity.RecipesList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsListRecipeDTO {

    private int id;

    private float qty;

    @JsonIgnore
    private RecipesListDTO recipesList;

    @JsonIgnore
    private ProductsListDTO productsList;

}
