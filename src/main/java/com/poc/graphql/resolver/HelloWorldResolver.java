package com.poc.graphql.resolver;


import com.poc.graphql.exceptions.ResourceNotFound;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

    public String graphQLError() {
        throw new ResourceNotFound("This is just some exception to show Custom GraphQL Exception Handler");
    }

    public String directiveValidationExample(String firstName, String lastName){
        return "if you are seeing this then directives validation passed";
    }

}
