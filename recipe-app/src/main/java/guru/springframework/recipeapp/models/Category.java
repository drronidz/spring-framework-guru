package guru.springframework.recipeapp.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/13/2022 10:54 PM
*/
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes ;
}
