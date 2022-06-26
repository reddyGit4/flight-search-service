package com.company.flight.services;

import com.company.flight.models.FlightSearchResponse;

import java.io.IOException;
import java.util.List;

public interface FlightSearchService {

    List<FlightSearchResponse> getFlightDetails(int day) throws IOException;
}
