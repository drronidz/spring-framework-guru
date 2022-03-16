package guru.springframework.recipeapp.services;

import com.sun.javaws.JnlpxArgs;
import guru.springframework.recipeapp.models.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;



import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/16/2022 4:19 PM
*/

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception{
        Recipe recipe = new Recipe();
        Set<Recipe> recipeDATA = new HashSet<>();
        recipeDATA.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeDATA);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}