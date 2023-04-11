package com.skypro.flightfinder.repository.specification;

import com.skypro.flightfinder.model.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import java.time.*;

public class DepartureSpecifications {

    public static Specification<Departure> byAirline(String airlineName) {
        return (root, query, criteriaBuilder) -> {
            if (airlineName == null || airlineName.isBlank()) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(
                    root.join(Departure_.airline).get(Airline_.name), airlineName);
        };
    }
    //TODO:ДОДЕЛАТЬ
    public static Specification<Departure> byAirport(String airport){
        return (root, query, criteriaBuilder) -> {
            if (airport == null || airport.isBlank()) return criteriaBuilder.conjunction();
            return criteriaBuilder.or(
                    criteriaBuilder.equal(root.join(Departure_.departureAirport).get(Airport_.name), airport),
                    criteriaBuilder.equal(root.join(Departure_.arrivalAirport).get(Airport_.name), airport));
        };
    }

    public static Specification<Departure> byCity(String city) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(city)) return criteriaBuilder.conjunction();
            return criteriaBuilder.or(
                    criteriaBuilder.equal(root.join(Departure_.departureAirport).get(Airport_.city), city),
                    criteriaBuilder.equal(root.join(Departure_.arrivalAirport).get(Airport_.city), city));
        };
    }

    public static Specification<Departure> byDepartureDate(LocalDate departureDate) {
        return (root, query, criteriaBuilder) -> {
            if (departureDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.between( root.get(Departure_.departureDate),
                            departureDate.atStartOfDay(),departureDate.atTime(23,59,59));
        };
    }

    public static Specification<Departure> byArrivalDate(LocalDate arrivalDate){
            return (root, query, criteriaBuilder) -> {
                if (arrivalDate == null) return criteriaBuilder.conjunction();
                return criteriaBuilder.between(root.get(Departure_.arrivalDate),
                        arrivalDate.atStartOfDay(), arrivalDate.atTime(23,59,59));
            };
        }
}
