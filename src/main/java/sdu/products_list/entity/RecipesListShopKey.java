package sdu.products_list.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipesListShopKey implements Serializable {
    @Column(name = "shop_list_id")
    Long shopListId;

    @Column(name = "recipes_list_id")
    Long recipesListId;
}
