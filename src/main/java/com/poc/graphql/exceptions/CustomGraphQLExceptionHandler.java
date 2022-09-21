package com.poc.graphql.exceptions;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;

import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLExceptionHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getError).collect(Collectors.toList());
    }

    private GraphQLError getError(GraphQLError graphQLError){
        if(graphQLError instanceof ExceptionWhileDataFetching){
            ExceptionWhileDataFetching ex = (ExceptionWhileDataFetching) graphQLError;

            if((ex.getException() instanceof GraphQLError)){
                return (GraphQLError) ex.getException();
            }
        }

        return graphQLError;
    }

}
