package com.solvd.airport.dao.connectionPool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {

    private static String  driver;
    private static String  url;
    private static String  username;
    private static String  password;

    private volatile int busyConnectionAmount;
    private static int  connectionsSize;
    private ArrayBlockingQueue<Connection> connections;
    private static ConnectionPool Instance;


    public static ConnectionPool getInstance() {

        if (Instance == null) {

            try {

                List <String> properties = ConnectionPool.getProperties();
                if (!(properties.isEmpty())) {

                    driver = properties.get(0);
                    url    = properties.get(1);
                    username  = properties.get(2);
                    password  = properties.get(3);
                    connectionsSize = Integer.parseInt(properties.get(4));
                }

                Instance = new ConnectionPool(driver,url,username,password,connectionsSize);
            } catch (SQLException e) {}

        }

        return Instance;
    }


    public ConnectionPool(String driver,
                          String url,
                          String username,
                          String password,
                          int connectionsSize
    ) throws SQLException {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;

        this.connectionsSize = connectionsSize;
        this.connections = new ArrayBlockingQueue<>(connectionsSize);
        this.busyConnectionAmount = 0;


        for (int i = 0; i < 3; i++){
            Connection conn = DriverManager.getConnection(url,username,password);
            connections.add(conn);
        }

    }

    public Connection getConnection() throws InterruptedException, SQLException {

        if (busyConnectionAmount <= connectionsSize) {
            if(connections.size() == 0) {
                busyConnectionAmount ++;
                connections.add(DriverManager.getConnection(url,username,password));
                return connections.take();

            } else if (connections.size() > 0){
                busyConnectionAmount++;
                return connections.take();
            }
        } else {

            return connections.take();

        }

        return null;
    }

    public boolean releaseConnection(Connection con) throws InterruptedException
    {
        if (connections.size() < connectionsSize) {
            busyConnectionAmount--;
            return connections.add(con);
        } else {
            return false;
        }
    }

    public boolean closeAllConnections() throws SQLException {

        if (connections.size() > 0){
            for (Connection connection:connections){
                connection.close();
            }
            return true;
        } else  return  false;
    }


    public static List<String> getProperties(){

        //read from file .properties
        FileInputStream fis;
        Properties property = new Properties();

        try {

            fis = new FileInputStream("resources/db.properties");
            property.load(fis);

            List<String> values = new ArrayList<>();

            values.add(property.getProperty("db.driver"));
            values.add(property.getProperty("db.url"));
            values.add(property.getProperty("db.login"));
            values.add(property.getProperty("db.password"));
            values.add(property.getProperty("db.connectionAmount"));

            return  values;


        } catch (IOException e) {

        }

        return null;

    }

}
