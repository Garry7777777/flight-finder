package com.skypro.flightfinder.repository;

import com.skypro.flightfinder.model.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long> {

    List<Departure> findFilteredDepartures(String airlineName, String airportName, String cityName, LocalDate departureDate, LocalDate arrivalDate);



}
