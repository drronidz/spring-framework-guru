package guru.springframework.recipeapp.controllers;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/13/2022 9:45 PM
*/

import guru.springframework.recipeapp.models.Category;
import guru.springframework.recipeapp.models.UnitOfMeasure;
import guru.springframework.recipeapp.repositories.CategoryRepository;
import guru.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {

        Optional<Category> categoryOne = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOne = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category ID is : " + categoryOne.get().getId());
        System.out.println("Unit Of Measure ID is : " + unitOfMeasureOne.get().getId());
        return "index";
    }
}
