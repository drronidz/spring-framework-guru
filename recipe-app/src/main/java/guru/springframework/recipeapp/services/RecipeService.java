package guru.springframework.recipeapp.services;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/15/2022 3:05 PM
*/

import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findRecipeCommandById(Long id);
    void deleteById(Long id);
}
