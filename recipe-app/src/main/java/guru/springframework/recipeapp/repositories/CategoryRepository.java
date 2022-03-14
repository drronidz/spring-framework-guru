package guru.springframework.recipeapp.repositories;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/13/2022 11:16 PM
*/

import guru.springframework.recipeapp.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
