package com.skypro.flightfinder.dto;

import com.skypro.flightfinder.model.Airport;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class AirportDTO {

    private Long id;
    private String name;
    private String city;
    private String address;


    public static AirportDTO toDTO(Airport airport) {
        AirportDTO dto = new AirportDTO();
        BeanUtils.copyProperties(airport,dto);
        return dto;
    }

}
