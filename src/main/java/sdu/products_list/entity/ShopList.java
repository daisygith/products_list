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
@Table(name = "shop_list")
public class ShopList {

    // dodanie kolumn
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // primary key
    @Column(name= "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
           cascade = CascadeType.ALL)
    @JoinTable(
        name = "recipes_list_shop",
        joinColumns = @JoinColumn(name = "shop_list_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "recipes_list_id", referencedColumnName = "id")

    )
   private List<RecipesList> recipesList;

    @OneToMany(mappedBy = "shopList", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<ProductsListShop> productsListShop;

}
