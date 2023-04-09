package com.skypro.flightfinder.controller;

import com.skypro.flightfinder.dto.DepartureDTO;
import com.skypro.flightfinder.model.Departure;
import com.skypro.flightfinder.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class DepartureController {
    @Autowired
    private DepartureService departureService;

    @GetMapping
    public List<DepartureDTO> getFlights(       @RequestParam(required = false)  String airlineName,
                                                @RequestParam(required = false)  String airportName,
                                                @RequestParam(required = false)  String cityName,
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  @RequestParam(required = false)  LocalDate departureDate,
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  @RequestParam(required = false)  LocalDate arrivalDate) {

        return departureService.getFlightsFiltered(airlineName, airportName, cityName, departureDate, arrivalDate);
    }

    @GetMapping("/{id}")
    public Departure getFlight(@PathVariable Long id) {

        return departureService.getDepartureById(id);
    }


}
