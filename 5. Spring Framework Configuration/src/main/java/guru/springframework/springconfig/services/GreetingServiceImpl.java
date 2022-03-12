package guru.springframework.springconfig.services;

/*
PROJECT NAME : dependency-injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/11/2022 7:02 PM
*/

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    public static final String HELLO_GURUS = "Hello Gurus !";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
