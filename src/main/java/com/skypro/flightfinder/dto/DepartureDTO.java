package com.skypro.flightfinder.dto;

import com.skypro.flightfinder.model.Departure;
import lombok.Data;
import java.time.LocalDate;
import java.time.ZoneOffset;


@Data
public class DepartureDTO {
    private String flightNumber;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String departureAirportName;
    private String arrivalAirportName;
    private String airlineName;

    public static DepartureDTO from(Departure departure) {
        DepartureDTO dto = new DepartureDTO();
        dto.setDepartureDate(LocalDate.from(departure.getDepartureDate().toInstant(ZoneOffset.UTC)));
        dto.setArrivalDate(LocalDate.from(departure.getArrivalDate().toInstant(ZoneOffset.UTC)));
        dto.setFlightNumber(departure.getFlightNumber());
        dto.setDepartureAirportName(departure.getDepartureAirport().getName());
        dto.setArrivalAirportName(departure.getArrivalAirport().getName());
        dto.setAirlineName(departure.getAirline().getName());
        return dto;
    }

}
