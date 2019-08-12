package com.solvd.airport.xml.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.airport.entity.Airport;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class AirportUnmarshalling {

    private static final Logger logJSON = Logger.getLogger(AirportUnmarshalling.class);

          public AirportUnmarshalling() throws IOException {

              File file = new File("C:src/main/java/com/solvd/airport/xml/json/Airport_Json.json");

              ObjectMapper objectMapper = new ObjectMapper();
              Airport airport = objectMapper.readValue(file, Airport.class);

              logJSON.info(airport);
    }
}
