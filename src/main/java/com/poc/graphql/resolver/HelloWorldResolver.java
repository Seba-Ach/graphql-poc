package com.poc.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Component
public class HelloWorldResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "hello world";
    }

    public String greetingMessage(String firstName, String secondName) {
        return "hello there " + firstName + " " + secondName;
    }

    // this uses the scalar defined in ScalarTypeConfig
    public LocalDateTime scalarTypeExample() {
        return LocalDateTime.now();
    }

    public String graphQLError(){
        throw new ResourceNotFound("This is just some exception to show Custom GraphQL Exception Handler");
    }

}
