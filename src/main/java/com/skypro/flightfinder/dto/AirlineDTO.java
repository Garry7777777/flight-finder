package com.skypro.flightfinder.dto;

import com.skypro.flightfinder.model.Airline;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class AirlineDTO {

    private Long id;
    private String name;

    public static AirlineDTO toDTO(Airline airline) {
        AirlineDTO dto = new AirlineDTO();
        BeanUtils.copyProperties(airline,dto);
        return dto;
    }
}
