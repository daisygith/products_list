package sdu.products_list.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes_list")
public class RecipesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    public RecipesList(String name) {
        this.name = name;
    }

    public RecipesList() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RecipesList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
