package guru.springramework.springjokesapp.services;

/*
PROJECT NAME : 4. Building A Spring Boot Jokes App
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 2:24 PM
*/

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes checkNorrisQuotes;

    public JokeServiceImpl() {
        this.checkNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return checkNorrisQuotes.getRandomQuote();
    }
}
