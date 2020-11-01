package com.spring.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.spring.graphql.exception.agency.AgencyNotFoundException;
import com.spring.graphql.exception.tour.TourNotFoundException;
import com.spring.graphql.model.Agency;
import com.spring.graphql.model.Tour;
import com.spring.graphql.payload.request.AgencyCreateRequest;
import com.spring.graphql.payload.request.AgencyUpdateRequest;
import com.spring.graphql.payload.request.TourCreateRequest;
import com.spring.graphql.payload.request.TourUpdateRequest;
import com.spring.graphql.repository.AgencyRepository;
import com.spring.graphql.repository.TourRepository;
import com.spring.graphql.service.agency.AgencyService;
import com.spring.graphql.service.tour.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.loadtime.Agent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
@Validated
public class MutationResolver implements GraphQLMutationResolver {

    TourService tourService;
    AgencyService agencyService;

    // createTour(input: CreateTourInput!) : Tour!
    @Transactional
    public Tour createTour(@Valid TourCreateRequest input) {
        return tourService.createTour(input);
    }

    // addAgency(name: String!, rating: Float) : Agency!
    @Transactional
    public Agency createAgency(@Valid AgencyCreateRequest input) {

        return agencyService.createAgency(input);
    }

    // updateAgencyRating(id: ID!, rating: Float!) : Agency!
    @Transactional
    public Agency updateAgency(Long id, @Valid AgencyUpdateRequest input) {
       return agencyService.updateAgency(id,input);
    }

    // updateTour(input: UpdateTourInput!) : Tour!
    @Transactional
    public Tour updateTour(Long id,@Valid TourUpdateRequest input) {
       return tourService.updateTour(id,input);
    }

    // deleteTour(id: ID!) : Long!
    @Transactional
    public Boolean deleteTour(Long id) {
       return tourService.deleteTour(id);
    }

    // deleteAgency(id: ID!) : Long!
    @Transactional
    public Boolean deleteAgency(Long id) {
        return agencyService.deleteAgency(id);
    }




}