package guru.springframework.springconfig;

/*
PROJECT NAME : dependency-injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 12:11 AM
*/

import com.diogonunes.jcolor.Attribute;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static ch.qos.logback.core.pattern.color.ANSIConstants.BOLD;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BOLD;

@Component
public class LifeCycleDemoBean implements
        InitializingBean,
        DisposableBean,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware {

    Attribute backgroundColorMain = Attribute.BACK_COLOR(7, 211, 0);
    Attribute textColorLight = Attribute.TEXT_COLOR(231, 231, 231);

    public LifeCycleDemoBean() {
        System.out.println(colorize(
                " ##### I'm in " + this.getClass().getSimpleName() + " Constructor ##### ",
                BOLD(),
                textColorLight,
                backgroundColorMain));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifeCycle Bean has been terminated!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The PreDestroy annotated method has been called");
    }

    public void beforeInit() {
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit() {
        System.out.println("## - After Init - Called by Bean Post Processor");
    }


}
