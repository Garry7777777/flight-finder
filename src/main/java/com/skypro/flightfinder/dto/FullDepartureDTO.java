package com.skypro.flightfinder.dto;

import com.skypro.flightfinder.model.Departure;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FullDepartureDTO {

    private String departureNumber;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;
    private AirlineDTO airline;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;


    public static FullDepartureDTO fromDeparture(Departure departure) {
        FullDepartureDTO dto = new FullDepartureDTO();
        dto.setDepartureNumber(departure.getDepartureNumber());
        dto.setDepartureAirport(AirportDTO.toDTO(departure.getDepartureAirport()));
        dto.setArrivalAirport(AirportDTO.toDTO(departure.getArrivalAirport()));
        dto.setAirline(AirlineDTO.toDTO(departure.getAirline()));
        dto.setDepartureDate(departure.getDepartureDate());
        dto.setArrivalDate(departure.getArrivalDate());
        return dto;
    }

}
