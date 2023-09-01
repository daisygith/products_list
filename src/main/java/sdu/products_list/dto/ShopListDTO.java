package sdu.products_list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sdu.products_list.entity.ProductsListShop;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopListDTO {

    // dodanie kolumn
    private int id;

    private String name;

    @JsonIgnore
    private List<RecipesListDTO> recipesList;
    @JsonIgnore
    private List<ShopListDTO> shopList;
    //@JsonIgnore
    private List<ProductsListShopDTO> productsListShop;

}
