package com.skypro.flightfinder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @SpringBootTest
    @AutoConfigureMockMvc
    public class DepartureTest {

        @Autowired
        MockMvc mockMvc;

        @Test
        void getDeparture() throws Exception {
            mockMvc.perform(get("/departures/" + "AA1243"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").isNotEmpty())
                    .andExpect(jsonPath("$.size()").value(6))
                    .andExpect(jsonPath("$.departureNumber").value("AA1243"));
        }

        @Test
        void getAirline() throws Exception {
            mockMvc.perform(get("/departures" + "?airlineName=Aeroflot"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").isNotEmpty())
                    .andExpect(jsonPath("$.size()").value(1))
                    .andExpect(jsonPath("$.*.departureNumber").value("UA153"));
        }
}
