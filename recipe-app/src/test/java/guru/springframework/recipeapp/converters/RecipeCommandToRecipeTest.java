package guru.springframework.recipeapp.converters;

import guru.springframework.recipeapp.commands.*;
import guru.springframework.recipeapp.models.Difficulty;
import guru.springframework.recipeapp.models.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/18/2022 11:58 AM
*/

public class RecipeCommandToRecipeTest {

    private static final Long RECIPE_ID = 1L;
    private static final Integer COOK_TIME = Integer.valueOf("5");
    private static final Integer PREP_TIME = Integer.valueOf("5");
    private static final String DESCRIPTION = "My Recipe";
    private static final String DIRECTIONS = "Directions";
    private static final Difficulty DIFFICULTY = Difficulty.EASY;
    private static final Integer SERVINGS = Integer.valueOf("3");
    private static final String SOURCE = "Source";
    private static final String URL = "URL";
    private static final Long CATEGORY_ID_ONE = 1L;
    private static final Long CATEGORY_ID_TWO = 1L;
    private static final Long INGREDIENT_ID_ONE = 3L;
    private static final Long INGREDIENT_ID_TWO = 4L;
    private static final Long NOTES_ID = 8L;

    RecipeCommandToRecipe converter;


    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(
                new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {

        //Given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);

        recipeCommand.setNotes(notesCommand);

        CategoryCommand categoryCommandOne = new CategoryCommand();
        categoryCommandOne.setId(CATEGORY_ID_ONE);

        CategoryCommand categoryCommandTwo = new CategoryCommand();
        categoryCommandTwo.setId(CATEGORY_ID_TWO);

        recipeCommand.getCategories().add(categoryCommandOne);
        recipeCommand.getCategories().add(categoryCommandTwo);

        IngredientCommand ingredientCommandOne = new IngredientCommand();
        ingredientCommandOne.setId(INGREDIENT_ID_ONE);

        IngredientCommand ingredientCommandTwo = new IngredientCommand();
        ingredientCommandTwo.setId(INGREDIENT_ID_TWO);

        recipeCommand.getIngredients().add(ingredientCommandOne);
        recipeCommand.getIngredients().add(ingredientCommandTwo);

        // When
        Recipe recipe = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());

    }
}