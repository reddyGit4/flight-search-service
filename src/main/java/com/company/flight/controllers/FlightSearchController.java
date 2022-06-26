package com.company.flight.controllers;

import com.company.flight.models.FlightSearchResponse;
import com.company.flight.services.FlightSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/flights")
@Tag(name = "Flight Search Service")
@Slf4j
public class FlightSearchController {

    @Autowired
    private FlightSearchService flightSearchService;


    @GetMapping("/{date}")
    @Operation(summary = "Get Flight Details", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit Card Details Retrieved Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public List<FlightSearchResponse> getFlightDetails(@PathVariable("date")  String date) {

        log.info("In getFlightDetails for date {}", date);

        //Convert date to weekday
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek day = localDate.getDayOfWeek();

        try {
            //call service with weekday value
            List<FlightSearchResponse> responseList = flightSearchService.getFlightDetails(day.getValue());
            return responseList.stream().sorted(Comparator.comparing(e -> e.getDepartureTime())).collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error reading csv file", e);
        }
        return Collections.EMPTY_LIST;
    }
}
