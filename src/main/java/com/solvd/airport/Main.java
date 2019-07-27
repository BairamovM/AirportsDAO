package com.solvd.airport;

import org.apache.log4j.Logger;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.solvd.airport.dao.connectionPool.ConnectionPool;

import com.solvd.airport.entity.Airplane;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main (String[] args) throws SQLException, ExecutionException, InterruptedException, ParserConfigurationException, SAXException, IOException {

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


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("C:src/main/java/com/solvd/airport/xml/Airplane.xml"));

        Element element = document.getDocumentElement();
        log.info(element.getTagName());

        NodeList nodeList = element.getChildNodes();

        LogXML(element.getChildNodes());


    }

    static void  LogXML (NodeList nodeList) {

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {

                log.info(((Element) nodeList.item(i)).getTagName());

                if (((Element) nodeList.item(i)).hasAttribute("firstname"))
                log.info(((Element) nodeList.item(i)).getAttribute("firstname"));

                if (nodeList.item(i).hasChildNodes()) {
                    log.info(nodeList.item(i).getChildNodes());
                }
            }
        }

    }

}
