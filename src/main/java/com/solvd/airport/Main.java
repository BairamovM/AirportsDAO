package com.solvd.airport;

import com.solvd.airport.xml.jaxb.JaxbMarshaller;
import com.solvd.airport.xml.jaxb.JaxbUnmarshaller;
import com.solvd.airport.xml.json.AirportMarshalling;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

import java.util.concurrent.ExecutionException;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);


    public static void main (String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException, ExecutionException, SQLException, JAXBException {


        //CompletableFutureStart completableFutureStart = new CompletableFutureStart();


        //Parser parser = new Parser();

        //JaxbMarshaller jaxbMarshaller = new JaxbMarshaller();

        //JaxbUnmarshaller jaxbUnmarshaller = new JaxbUnmarshaller();

        AirportMarshalling airportMarshalling = new AirportMarshalling();
        airportMarshalling.Marshall();
    }



}
