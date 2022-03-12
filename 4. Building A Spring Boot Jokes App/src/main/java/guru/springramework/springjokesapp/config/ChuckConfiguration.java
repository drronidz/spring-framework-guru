package guru.springramework.springjokesapp.config;

/*
PROJECT NAME : 4. Building A Spring Boot Jokes App
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 4:27 PM
*/

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChuckConfiguration {

    @Bean
    public ChuckNorrisQuotes chuckNorrisQuotes() {
        return new ChuckNorrisQuotes();
    }
}
