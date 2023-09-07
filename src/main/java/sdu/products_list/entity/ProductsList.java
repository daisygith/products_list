package sdu.products_list.entity;

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
@Entity
@Table(name="products_list")
public class ProductsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="unit")
    private String unit;

    @OneToMany(mappedBy = "productsList", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<ProductsListRecipe> productsListRecipes;

    @OneToMany(mappedBy = "productsList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductsListShop> productsListShop;


}
