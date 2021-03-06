package com.spring.graphql.bootstrap;


import com.spring.graphql.enums.TourType;
import com.spring.graphql.model.Agency;
import com.spring.graphql.model.Tour;
import com.spring.graphql.repository.AgencyRepository;
import com.spring.graphql.repository.TourRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class InitDataLoader implements CommandLineRunner {

    @NonNull TourRepository tourRepository;
    @NonNull AgencyRepository agencyRepository;

    @Override
    public void run(String... args) throws Exception {
        Agency lAgency = new Agency(1L, "AtoZTours", 5d);
        agencyRepository.save(lAgency);
        Stream.of(
                new Tour(1L, "Trondheim", "233", "2",
                        "Trondheim Kunstmuseum is an art museum located in Trondheim in Sør-Trøndelag county, Norway.", TourType.ECONOMY, lAgency),
                new Tour(2L, "Nidaros Cathedral", "100", "1",
                        "Nidaros Cathedral is a Church of Norway cathedral located in the city of Trondheim in Trøndelag county, Norway", TourType.COUPLE, lAgency),
                new Tour(3L, "Nidelva", "343", "2",
                        "Nidelva is a river in Trøndelag county, Norway. The 30-kilometre long river travels through the municipalities of Trondheim and Klæbu.", TourType.ADVENTURE, lAgency))
                .forEach(tourRepository::save);

    }
}
