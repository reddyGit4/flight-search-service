package com.company.flight.services.impl;

import com.company.flight.models.FlightSearchResponse;
import com.company.flight.services.FlightSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.company.flight.test.TestData.aFlightResponseUnsortedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
public class CSVFlightSearchServiceTest {

    private FlightSearchService unit;

    @BeforeEach
    public void setUp(){
        this.unit = new CSVFlightSearchService();
    }

    @Test
    void test_flightDetailsAsExpected() throws IOException {

        //given
        int day = 7;

        //when
        List<FlightSearchResponse> responseList =  unit.getFlightDetails(day);

        //then
        assertThat(responseList).isEqualTo(aFlightResponseUnsortedList());
    }

    @Test
    void test_flightDetailsEmptyList() throws IOException {

        //given
        int day = 6;

        //when
        List<FlightSearchResponse> responseList =  unit.getFlightDetails(day);

        //then
        assertThat(responseList).isEqualTo(Collections.emptyList());
    }

}
