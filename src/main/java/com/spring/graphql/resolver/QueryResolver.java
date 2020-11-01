package com.spring.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.spring.graphql.model.Agency;
import com.spring.graphql.model.Tour;
import com.spring.graphql.service.agency.AgencyService;
import com.spring.graphql.service.tour.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    TourService tourService;
    AgencyService agencyService;

    // allTours: [Tour]
    public List<Tour> listTour() {
        return tourService.listTour();
    }

    //allAgencies: [Agency]
    public List<Agency> listAgency() {
        return agencyService.listAgency();
    }


    //tour(id: Long!): Tour
    public Tour getTour(Long id) {
        return tourService.getTour(id);
    }


    //agency(id: Long!): Agency
    public Agency getAgency(Long id) {
        return agencyService.getAgency(id);
    }
}