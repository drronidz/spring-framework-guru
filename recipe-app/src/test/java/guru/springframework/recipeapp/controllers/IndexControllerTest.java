package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/15/2022 4:41 PM
*/

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {
        // Given ...
        String viewName = controller.getIndexPage(model);

        assertEquals("index",viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}