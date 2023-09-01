package sdu.products_list.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products_list_shop")
public class ProductsListShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "qty")
    private float qty;

    @ManyToOne
    @JoinColumn(name = "products_list_id", nullable = true)
    private ProductsList productsList;

    @ManyToOne
    @JoinColumn(name = "shop_list_id", nullable = true)
    private ShopList shopList;

}
