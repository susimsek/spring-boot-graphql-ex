package com.spring.graphql.exception.agency;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AgencyAlreadyExistsException extends RuntimeException implements GraphQLError {

    private String agencyName;

    public AgencyAlreadyExistsException(String agencyName) {
        this.agencyName = agencyName;
    }


    @Override
    public String getMessage() {
        return "Agency with Name " + agencyName + " already exists";
    }



    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }



    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("agencyName", agencyName);
    }



    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}