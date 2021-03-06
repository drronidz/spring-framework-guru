package guru.springframework.recipeapp.commands;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/17/2022 11:31 PM
*/

import guru.springframework.recipeapp.models.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();

}
