package com.company.flight.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
public class FlightSearchResponse {

    private LocalTime departureTime;
    private String destination;
    private String destinationIATA;
    private String flightNo;



}
