package guru.springframework.recipeapp.converters;

import guru.springframework.recipeapp.commands.IngredientCommand;
import guru.springframework.recipeapp.models.Ingredient;
import guru.springframework.recipeapp.models.Recipe;
import guru.springframework.recipeapp.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/18/2022 2:23 PM
*/

public class IngredientToIngredientCommandTest {

    private static final Recipe RECIPE = new Recipe();
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final String DESCRIPTION = "Cheeseburger";
    private static final Long UNIT_OF_MEASURE_ID = new Long(2L);
    private static final Long ID_VALUE = new Long(1L);
    private static final Long RECIPE_ID = new Long(3L);

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObjectConverter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void testConvertNullUnityOfMeasure() throws Exception {
        //GIVEN
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUnitOfMeasure(null);

        //WHEN
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //THEN
        assertNull(ingredientCommand.getUnitOfMeasureCommand());
        assertEquals(ID_VALUE, ingredientCommand.getId());
        //assertEquals(RECIPE, ingredientCommand.get);
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }

    @Test
    public void testConvertWithUnitOfMeasure() {
        //GIVEN
        RECIPE.setId(RECIPE_ID);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UNIT_OF_MEASURE_ID);

        ingredient.setUnitOfMeasure(unitOfMeasure);

        //WHEN
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //THEN
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUnitOfMeasureCommand());
        assertEquals(UNIT_OF_MEASURE_ID, ingredientCommand.getUnitOfMeasureCommand().getId());
        assertEquals(RECIPE_ID, ingredientCommand.getRecipeId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }
}