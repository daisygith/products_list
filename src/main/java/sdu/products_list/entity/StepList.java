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
@Table(name = "step_list")
public class StepList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "step_nr")
    private int stepNr;

    @Column(name = "description")
    private String description;

//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "recipes_list_id", nullable = true)
    private RecipesList recipesList;


    //private int recipesListId;

}
