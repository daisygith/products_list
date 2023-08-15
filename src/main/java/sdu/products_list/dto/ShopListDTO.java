package sdu.products_list.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopListDTO {

    // dodanie kolumn
    private int id;

    private String name;

    private List<RecipesListShopDTO> recipesListShop;

}
