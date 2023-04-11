package com.skypro.flightfinder.service;

import com.skypro.flightfinder.dto.DepartureDTO;
import com.skypro.flightfinder.dto.FullDepartureDTO;
import com.skypro.flightfinder.model.Departure;
import com.skypro.flightfinder.repository.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import static com.skypro.flightfinder.repository.specification.DepartureSpecifications.*;

@Service
public class DepartureService {

    @Autowired
    private DepartureRepository departureRepository;


    public List<DepartureDTO> getDeparturesFiltered(String airline, String airport, String city,
                                                 LocalDate departureDate, LocalDate arrivalDate) {

        List<Departure> departures = departureRepository.findAll(Specification.where(
                              byAirline(airline))
                        .and( byAirport(airport))
                        .and( byCity(city))
                        .and( byDepartureDate(departureDate))
                        .and( byArrivalDate(arrivalDate)));
        return departures.stream().map(DepartureDTO::fromDeparture).collect(Collectors.toList());
    }

    public FullDepartureDTO getDepartureById(String departure) {
         return FullDepartureDTO.fromDeparture( departureRepository.findByDepartureNumber(departure).orElseThrow()) ;
    }
}
