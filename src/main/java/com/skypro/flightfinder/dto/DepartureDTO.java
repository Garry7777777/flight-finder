package com.skypro.flightfinder.dto;

import com.skypro.flightfinder.model.Departure;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class DepartureDTO {
    private String departureNumber;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String departureAirport;
    private String arrivalAirport;
    private String airline;

    public static DepartureDTO fromDeparture(Departure departure) {
        DepartureDTO dto = new DepartureDTO();
        dto.setDepartureDate(departure.getDepartureDate());
        dto.setArrivalDate(departure.getArrivalDate());
        dto.setDepartureNumber(departure.getDepartureNumber());
        dto.setDepartureAirport(departure.getDepartureAirport().getName());
        dto.setArrivalAirport(departure.getArrivalAirport().getName());
        dto.setAirline(departure.getAirline().getName());
        return dto;
    }

}
