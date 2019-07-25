package com.solvd.airport;

import org.apache.log4j.Logger;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.solvd.airport.dao.connectionPool.ConnectionPool;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main (String[] args) throws SQLException, ExecutionException, InterruptedException {

    log.info("First log message");

        //create pool connection  ?useSSL=false
        ConnectionPool connectionPool = new ConnectionPool(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/?useSSL=false", "Neuromancer", "Neuromancer",9
        );

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {

            List<Connection> connections = new ArrayList<>();

            try {

                for (int i = 0;i < 10;i++){
                    connections.add(connectionPool.getConnection());
                    log.info("Connection added to DB = " + i);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                log.info("SQLException message");
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info("InterruptedException");
            }



        });

        future.get();

        log.info(future.isDone());
        log.info(future.isCancelled());
        log.info(future.toCompletableFuture());
        log.info(future.toString());

    }

}
