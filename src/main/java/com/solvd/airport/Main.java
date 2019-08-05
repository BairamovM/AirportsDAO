package com.solvd.airport;

import com.solvd.airport.dao.connectionPool.CompletableFutureStart;
import com.solvd.airport.xml.jaxb.JaxbReader;
import com.solvd.airport.xml.jaxb.JaxbWriter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

import java.util.concurrent.ExecutionException;

import com.solvd.airport.xml.Parser;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);


    public static void main (String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException, ExecutionException, SQLException, JAXBException {


        //CompletableFutureStart completableFutureStart = new CompletableFutureStart();


        //Parser parser = new Parser();

        //JaxbWriter jaxbWriter = new JaxbWriter();
        JaxbReader jaxbReader = new JaxbReader();
    }



}
