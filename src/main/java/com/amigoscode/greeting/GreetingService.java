package com.amigoscode.greeting;

// TODO: 01 - Add @Component annotation to this class so Spring manages it as a bean

// TODO: 03 - Add @Qualifier("greetingMessage") to the constructor parameter

// TODO: 04 - Add @PostConstruct and @PreDestroy lifecycle hooks

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    private final String greeting;

    public GreetingService(@Qualifier("greetingMessage") String greeting) {
        this.greeting = greeting;
    }

    @PostConstruct
    public String postConstruct(){
        return "Starting...";
    }

    @PreDestroy
    public String preDestroy(){
        return "Finished";
    }

    public String greet(String name) {
        return greeting + ", " + name + "!";
    }

}
