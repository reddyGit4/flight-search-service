package com.company.flight.test;

import com.company.flight.models.FlightSearchResponse;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static FlightSearchResponse aFlightResponseData1() {

        return FlightSearchResponse.builder()
                .flightNo("VS097")
                .departureTime(LocalTime.parse("09:00"))
                .destinationIATA("UVF")
                .destination("St Lucia").build();
    }

    public static FlightSearchResponse aFlightResponseData2() {

        return FlightSearchResponse.builder()
                .flightNo("VS015")
                .departureTime(LocalTime.parse("13:00"))
                .destinationIATA("MCO")
                .destination("Orlando").build();
    }

    public static FlightSearchResponse aFlightResponseData3() {

        return FlightSearchResponse.builder()
                .flightNo("VS097")
                .departureTime(LocalTime.parse("09:00"))
                .destinationIATA("TAB")
                .destination("Tobago").build();
    }

    public static List<FlightSearchResponse> aFlightResponseUnsortedList() {

        List<FlightSearchResponse> responseList = new ArrayList<>();
        responseList.add(aFlightResponseData1());
        responseList.add(aFlightResponseData2());
        responseList.add(aFlightResponseData3());
        return responseList;
    }

    public static List<FlightSearchResponse> aFlightResponseSortedList() {

        List<FlightSearchResponse> responseList = new ArrayList<>();
        responseList.add(aFlightResponseData1());
        responseList.add(aFlightResponseData3());
        responseList.add(aFlightResponseData2());

        return responseList;
    }
}
