package guru.springframework.recipeapp.converters;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/18/2022 2:21 PM
*/

import guru.springframework.recipeapp.commands.IngredientCommand;
import guru.springframework.recipeapp.models.Ingredient;
import guru.springframework.recipeapp.models.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientToIngredientCommand implements
        Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.converter = converter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());

        if (source.getRecipe() != null) {
            ingredientCommand.setRecipeId(source.getRecipe().getId());
        }
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(source.getUnitOfMeasure().getId());
        unitOfMeasure.setDescription(source.getUnitOfMeasure().getDescription());

        ingredientCommand.setUnitOfMeasureCommand(converter.convert(unitOfMeasure));

        return ingredientCommand;
    }
}
