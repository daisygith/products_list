package sdu.products_list.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes_list")
public class RecipesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

   // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "recipesList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StepList> stepList;

//    @OneToMany(mappedBy = "recipesList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<RecipesListShop> recipesListShops;

    @OneToMany(mappedBy = "recipesList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductsListRecipe> productsListRecipes;

//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    //  @JoinColumn(name = "shop_list_id", nullable = true)
//
//    @JoinTable(
//            name = "recipes_list_shop",
//            joinColumns = @JoinColumn(name = "recipes_list_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "shop_list_id", referencedColumnName = "id")
//
//    )
//    private Set<ShopList> shopListSet;
    @OneToMany(mappedBy = "recipesList")
    private Set<RecipesListShop> recipeListShops;



}
