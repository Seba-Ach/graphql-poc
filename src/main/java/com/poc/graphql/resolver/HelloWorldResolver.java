package com.poc.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "hello world";
    }

    public String greetingMessage(String firstName, String secondName) {
        return "hello there " + firstName + " " + secondName;
    }

}
