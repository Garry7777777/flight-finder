package com.skypro.flightfinder.service;

import com.skypro.flightfinder.dto.DepartureDTO;
import com.skypro.flightfinder.model.Departure;
import com.skypro.flightfinder.repository.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartureService {

    @Autowired
    private DepartureRepository departureRepository;


    public List<DepartureDTO> getFlightsFiltered(String airlineName,
                                                 String airportName,
                                                 String cityName,
                                                 LocalDate departureDate, LocalDate arrivalDate) {
        List<Departure> departures = departureRepository.findFilteredDepartures(airlineName, airportName, cityName, departureDate, arrivalDate);

        return departures.stream().map(DepartureDTO::from).collect(Collectors.toList());
    }

    public Departure getDepartureById(Long id) {
        return null;
    }
}
