package guru.springframework.recipeapp.converters;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/18/2022 11:17 AM
*/

import com.sun.istack.Nullable;
import guru.springframework.recipeapp.commands.IngredientCommand;
import guru.springframework.recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.recipeapp.models.Ingredient;
import guru.springframework.recipeapp.models.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements
        Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());

        if (source.getRecipeId() != null) {
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }
        ingredient.getRecipe().setId(source.getRecipeId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getUnitOfMeasureCommand().getId());
        unitOfMeasureCommand.setDescription(source.getUnitOfMeasureCommand().getDescription());

        ingredient.setUnitOfMeasure(uomConverter.convert(unitOfMeasureCommand));

        return ingredient;
    }
}
