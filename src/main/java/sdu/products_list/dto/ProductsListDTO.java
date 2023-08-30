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
public class ProductsListDTO {

    private int id;

    private String name;

    private String unit;

    private List<ProductsListRecipeDTO> productsListRecipe;
}
