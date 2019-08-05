package com.solvd.airport.dao.connectionPool;

import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.solvd.airport.dao.connectionPool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompletableFutureStart  {

    private static final Logger log = Logger.getLogger(CompletableFutureStart.class);

    //create pool connection  ?useSSL=false
    ConnectionPool connectionPool = new ConnectionPool(
            "com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost:3306/?useSSL=false", "Neuromancer", "Neuromancer",9
    );

    java.util.concurrent.CompletableFuture<Void> future = java.util.concurrent.CompletableFuture.runAsync(() -> {

        List<Connection> connections = new ArrayList<>();

        try {

            for (int i = 0;i < 10;i++){
                connections.add(connectionPool.getConnection());
                log.info("Connection added to DB = " + i);
            }

        } catch (SQLException e) {
            log.info("SQLException message");
        } catch (InterruptedException e) {
            log.info("InterruptedException");
        }



    });


    public CompletableFutureStart() throws SQLException, ExecutionException, InterruptedException {

        future.get();

        log.info(future.isDone());
        log.info(future.isCancelled());
        log.info(future.toCompletableFuture());
        log.info(future.toString());

    }



}
