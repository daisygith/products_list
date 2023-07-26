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
@Table(name = "shop_list")
public class ShopList {

    // dodanie kolumn
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // primary key
    @Column(name= "id")
    private int id;

    @Column(name = "name")
    private String name;

}
