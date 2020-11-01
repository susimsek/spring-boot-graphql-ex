package com.spring.graphql.error;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> graphQLErrors) {
        List<GraphQLError> clientErrors = graphQLErrors.stream()
                .filter(this::isClientError)
                .collect(Collectors.toList());

        List<GraphQLError> serverErrors = graphQLErrors.stream()
                .filter(e -> !isClientError(e))
                .map(GraphQLErrorAdapter::new)
                .collect(Collectors.toList());

        List<GraphQLError> graphQLErrorList = new ArrayList<>();
        graphQLErrorList.addAll(clientErrors);
        graphQLErrorList.addAll(serverErrors);
        return graphQLErrorList;
    }

    private boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
    }

}