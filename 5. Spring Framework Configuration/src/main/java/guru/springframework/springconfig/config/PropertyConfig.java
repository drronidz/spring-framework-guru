package guru.springframework.springconfig.config;

import guru.springframework.springconfig.properties.FakeDataSource;
import guru.springframework.springconfig.properties.FakeJMSBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
PROJECT NAME : 5. Spring Framework Configuration
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 10:31 PM
*/
@Configuration
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    // Data Source Properties
    @Value("${guru.username}")
    String dataSourceUser;

    @Value("{guru.password}")
    String dataSourcePassword;

    @Value("{guru.dburl}")
    String dataSourceUrl;

    // JMS Properties
    @Value("${guru.jms.username}")
    String jmsUsername;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value("${guru.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(dataSourceUser);
        fakeDataSource.setPassword(dataSourcePassword);
        fakeDataSource.setUrl(dataSourceUrl);
        return fakeDataSource;
    }

    @Bean
    public FakeJMSBroker fakeJMSBroker() {
        FakeJMSBroker fakeJMSBroker = new FakeJMSBroker();
        fakeJMSBroker.setUsername(jmsUsername);
        fakeJMSBroker.setPassword(jmsPassword);
        fakeJMSBroker.setUrl(jmsUrl);
        return fakeJMSBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
