package org.webonise.springpolygonapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;


@Configuration
public class AppConfig {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ConsoleHandler getConsoleHandler() {
        return new ConsoleHandler();
    }
}
