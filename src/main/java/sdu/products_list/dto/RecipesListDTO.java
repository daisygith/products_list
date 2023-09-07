package sdu.products_list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<ShopListDTO> shopListSet;
    private List<ProductsListRecipeDTO> productsListRecipe;

}
