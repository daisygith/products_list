package sdu.products_list.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="recipes_list_shop")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipesListShop {
    @EmbeddedId
    RecipesListShopKey id;

    @ManyToOne
    @MapsId("shopListId")
    @JoinColumn(name = "shop_list_id")
    ShopList shopList;

    @ManyToOne
    @MapsId("recipesListId")
    @JoinColumn(name = "recipes_list_id")
    RecipesList recipesList;

}
