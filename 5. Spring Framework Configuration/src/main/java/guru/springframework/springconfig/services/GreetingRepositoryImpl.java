package guru.springframework.springconfig.services;

import com.diogonunes.jcolor.Attribute;
import org.springframework.stereotype.Component;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BOLD;

/*
PROJECT NAME : dependency-injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/11/2022 11:44 PM
*/
@Component
public class GreetingRepositoryImpl implements GreetingRepository{

    Attribute backgroundColorOne = Attribute.BACK_COLOR(48, 188, 237);
    Attribute backgroundColorTwo = Attribute.BACK_COLOR(48, 48, 54);
    Attribute backgroundColorThree = Attribute.BACK_COLOR(202, 254, 72);

    Attribute textColorDark = Attribute.TEXT_COLOR(0, 0, 0);
    Attribute textColorLight = Attribute.TEXT_COLOR(231, 231, 231);

    @Override
    public String getEnglishGreeting() {
        return colorize("Primary Greeting Service", BOLD(), textColorDark, backgroundColorOne);
    }

    @Override
    public String getSpanishGreeting() {
        return colorize("Servicio de Saludo Primario", BOLD(), textColorLight, backgroundColorTwo);
    }

    @Override
    public String getFrenchGreeting() {
        return colorize("Service de Salutation Primaire", BOLD(), textColorDark, backgroundColorThree);
    }
}
