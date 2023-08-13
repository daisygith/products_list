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

}
