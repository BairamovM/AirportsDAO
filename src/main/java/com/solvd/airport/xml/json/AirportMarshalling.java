package com.solvd.airport.xml.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.airport.entity.Airport;
import com.solvd.airport.entity.AirportClass;
import com.solvd.airport.entity.Country;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class AirportMarshalling {

    private static final Logger logJSON = Logger.getLogger(AirportMarshalling.class);


    public void Marshall () throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Airport airport = new Airport();
        AirportClass airportClass = new AirportClass();
        Country country = new Country();

        country.setId(1);
        country.setNameCountry("Ukraine");

        airportClass.setId(1);
        airportClass.setClassType(3);

        airport.setId(1);
        airport.setNameAirport("Boruspil");
        airport.setAirportClass(airportClass);
        airport.setCountry(country);

        String result = new ObjectMapper().writeValueAsString(airport);
        objectMapper.writeValue(new File("C:src/main/java/com/solvd/airport/xml/json/Airport_Json.json"), airport);

        logJSON.info(airport);

    }

}
