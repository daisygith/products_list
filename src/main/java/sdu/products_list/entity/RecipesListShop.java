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
@Table(name = "recipes_list_shop")
public class RecipesListShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "recipes_list_id", nullable = true)
    private RecipesList recipesList;

}
