package guru.springframework.recipeapp.models;

/*
PROJECT NAME : recipe-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/13/2022 10:49 PM
*/

public enum Difficulty {
    EASY, MODERATE, KIND_OF_HARD, HARD;

    public String convertDifficultyToString(Difficulty difficulty) {
        return difficulty.toString().replace("_", " ");
    }
}
