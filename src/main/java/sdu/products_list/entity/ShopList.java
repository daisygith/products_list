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

//    public ShopList(String name) {
//        this.name = name;
//    }
//
//    // konstructor wszystko bez id
//    public ShopList(){
//
//    }
//
//    // getter setter - dla wszystkich zmiennych nawet id
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    // toString() także ze wszystkimi zmiennymi
//
//    @Override
//    public String toString() {
//        return "ShopList{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
