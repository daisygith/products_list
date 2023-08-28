package sdu.products_list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<RecipesListDTO> recipesList;

}
