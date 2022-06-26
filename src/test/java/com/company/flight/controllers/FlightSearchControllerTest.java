package com.company.flight.controllers;

import com.company.flight.models.FlightSearchResponse;
import com.company.flight.services.FlightSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.company.flight.test.TestData.aFlightResponseSortedList;
import static com.company.flight.test.TestData.aFlightResponseUnsortedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FlightSearchControllerTest {

    private FlightSearchController unit;

    @Mock
    private FlightSearchService flightSearchServiceMock;

    @BeforeEach
    public void setUp(){
        this.unit = new FlightSearchController(flightSearchServiceMock);
    }

    @Test
    void test_AsExpected() throws IOException {

        //given
        String date = "2022-06-26";
        given(flightSearchServiceMock.getFlightDetails(7)).willReturn(aFlightResponseUnsortedList());

        //when
        List<FlightSearchResponse> actualResponse = unit.getFlightDetails(date);

        //then
        assertThat(actualResponse).isEqualTo(aFlightResponseSortedList());

    }

    @Test
    void test_FailsWithEmptyList() throws IOException {

        //given
        String date = "2022-06-26";
        given(flightSearchServiceMock.getFlightDetails(7)).willThrow(IOException.class);

        //when
        List<FlightSearchResponse> actualResponse = unit.getFlightDetails(date);

        //then
        assertThat(actualResponse).isEqualTo(Collections.EMPTY_LIST);

    }
}
