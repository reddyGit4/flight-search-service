package com.company.flight.services.impl;

import com.company.flight.models.FlightSearchResponse;
import com.company.flight.services.FlightSearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV version of Flight Search implementation
 */
@Slf4j
@AllArgsConstructor
@Service
public class CSVFlightSearchService implements FlightSearchService {

    private static final String FILE_PATH = "classpath:flights.csv";
    private static final String DAY_MARK = "x";

    @Override
    public List<FlightSearchResponse> getFlightDetails(int day) throws IOException {

        log.info("In getFlightDetails with day {}", day);

        //convert day to csv file day location where it sunday starts with index 4 in csv
        day = (day == 7) ? 4 : day + 4;
        List<FlightSearchResponse> responseList = new ArrayList<>();

        //read each line
        LineIterator it = FileUtils.lineIterator(ResourceUtils.getFile(FILE_PATH), "UTF-8");
        try {
            while (it.hasNext()) {
                //split with 11 times so that we can avoid null exception
                String[] line = it.nextLine().split(",",11);

                //Find flights which are equal to the passed in day value
                if (DAY_MARK.equalsIgnoreCase(line[day])) {
                    responseList.add(new FlightSearchResponse(LocalTime.parse(line[0]), line[1], line[2], line[3]));
                }
            }
        } finally {
            it.close();
        }
        return responseList;
    }
}
