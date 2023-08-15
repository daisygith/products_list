package sdu.products_list.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sdu.products_list.entity.RecipesList;

@Data
@Builder
@AllArgsConstructor
public class RecipesListShopDTO {

    private int id;
    private RecipesListDTO recipesList;

    private ShopListDTO shopList;

}
