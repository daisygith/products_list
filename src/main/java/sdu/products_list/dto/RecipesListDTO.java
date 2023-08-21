package sdu.products_list.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipesListDTO {

    private int id;

    private String name;

    private List<StepListDTO> stepList;

   // private List<RecipesListShopDTO> recipesListShop;

    private List<ProductsListRecipeDTO> productsListRecipe;

    private List<ShopListDTO> shopListSet;
}
