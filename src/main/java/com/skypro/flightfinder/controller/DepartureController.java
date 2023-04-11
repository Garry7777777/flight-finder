package com.skypro.flightfinder.controller;

import com.skypro.flightfinder.dto.DepartureDTO;
import com.skypro.flightfinder.dto.FullDepartureDTO;
import com.skypro.flightfinder.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/departures")
public class DepartureController {
    @Autowired
    private DepartureService departureService;

    @GetMapping
    public List<DepartureDTO> getDepartures(    @RequestParam(required = false)  String airlineName,
                                                @RequestParam(required = false)  String airportName,
                                                @RequestParam(required = false)  String cityName,
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  @RequestParam(required = false)  LocalDate departureDate,
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  @RequestParam(required = false)  LocalDate arrivalDate) {

        return departureService.getDeparturesFiltered(airlineName, airportName, cityName, departureDate, arrivalDate);
    }

    @GetMapping("/{departure}")
    public FullDepartureDTO getDepartureById(@PathVariable String departure) {

        return departureService.getDepartureById(departure);
    }


}
