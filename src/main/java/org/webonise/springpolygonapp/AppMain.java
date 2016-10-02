package org.webonise.springpolygonapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppMain.class, args);
        Application application = context.getBean(Application.class);
        application.startApplication();
    }
}
