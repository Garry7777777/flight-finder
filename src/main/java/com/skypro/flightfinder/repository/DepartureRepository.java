package com.skypro.flightfinder.repository;

import com.skypro.flightfinder.model.Departure;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long>, JpaSpecificationExecutor<Departure> {

 //   List<Departure> findFilteredDepartures(String airlineName, String airportName, String cityName, LocalDate departureDate, LocalDate arrivalDate);

    @Override
    @EntityGraph(attributePaths = {"departureAirport", "arrivalAirport", "airline"})
    List<Departure> findAll(Specification<Departure> specification);

    @EntityGraph(attributePaths = {"departureAirport", "arrivalAirport", "airline"})
    Optional<Departure> findByDepartureNumber(String departureNumber);
}
