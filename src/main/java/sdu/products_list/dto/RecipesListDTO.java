package sdu.products_list.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipesListDTO {

    private int id;

    private String name;

    private StepListDTO stepList;
}
