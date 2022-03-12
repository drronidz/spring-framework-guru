package guru.springramework.springjokesapp.controllers;

/*
PROJECT NAME : 4. Building A Spring Boot Jokes App
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 2:33 PM
*/

import guru.springramework.springjokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        return "chucknorris";
    }
}
