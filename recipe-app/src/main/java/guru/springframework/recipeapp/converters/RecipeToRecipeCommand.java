package guru.springframework.recipeapp.converters;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/18/2022 3:24 PM
*/

import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.models.Category;
import guru.springframework.recipeapp.models.Ingredient;
import guru.springframework.recipeapp.models.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter,
                                 IngredientToIngredientCommand ingredientConverter,
                                 NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        } else {
            final RecipeCommand recipeCommand = new RecipeCommand();
            recipeCommand.setId(source.getId());
            recipeCommand.setCookTime(source.getCookTime());
            recipeCommand.setPrepTime(source.getPrepTime());
            recipeCommand.setDescription(source.getDescription());
            recipeCommand.setDifficulty(source.getDifficulty());
            recipeCommand.setDirections(source.getDirections());
            recipeCommand.setServings(source.getServings());
            recipeCommand.setSource(source.getSource());
            recipeCommand.setUrl(source.getUrl());
            recipeCommand.setNotes(notesConverter.convert(source.getNotes()));

            if (source.getCategories() != null && source.getCategories().size() > 0) {
                source.getCategories()
                        .forEach(category -> {
                            recipeCommand.getCategories().add(categoryConverter.convert(category));
                        });
            }

            if (source.getIngredients() != null && source.getIngredients().size() > 0) {
                source.getIngredients()
                        .forEach(ingredient -> {
                            recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient));
                        });
            }

            return recipeCommand;
        }
    }
}
