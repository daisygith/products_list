package sdu.products_list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StepListDTO {

    private int id;

    private int stepNr;

    private String description;

    @JsonIgnore
    private RecipesListDTO recipesList;
}
