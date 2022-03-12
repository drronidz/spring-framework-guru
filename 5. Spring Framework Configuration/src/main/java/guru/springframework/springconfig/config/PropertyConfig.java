package guru.springframework.springconfig.config;

import guru.springframework.springconfig.data.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
PROJECT NAME : 5. Spring Framework Configuration
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 10:31 PM
*/
@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${guru.username}")
    String user;

    @Value("{guru.password}")
    String password;

    @Value("{guru.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);

        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
