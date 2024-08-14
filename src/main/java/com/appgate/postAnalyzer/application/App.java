package com.appgate.postAnalyzer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@ComponentScan(basePackages = "com.appgate.postAnalyzer")
@EnableWebFlux
@EnableScheduling
@EnableR2dbcRepositories("com.appgate.postAnalyzer.infrastructure.db")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
