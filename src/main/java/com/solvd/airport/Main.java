package com.solvd.airport;

import com.solvd.airport.dao.connectionPool.CompletableFutureStart;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.solvd.airport.dao.connectionPool.ConnectionPool;

import com.solvd.airport.xml.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);


    public static void main (String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException, ExecutionException, SQLException {


        //CompletableFutureStart completableFutureStart = new CompletableFutureStart();


        Parser parser = new Parser();

    }



}
