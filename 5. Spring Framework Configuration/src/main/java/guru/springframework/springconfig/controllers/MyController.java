package guru.springframework.springconfig.controllers;

/*
PROJECT NAME : dependency-injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/11/2022 6:32 PM
*/

import guru.springframework.springconfig.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String helloWorld() {
        System.out.println("Hello World from " + this.getClass().getSimpleName());
        return greetingService.sayGreeting();
    }
}
