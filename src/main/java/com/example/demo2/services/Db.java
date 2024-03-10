package com.example.demo2.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private Connection con;

    public Connection getcon(){
        return con;
    }

    public Db() {

        String host = "mysql-14ec272b-meftahahmedreda02-60b9.a.aivencloud.com";
        String port = "19015";
        String databaseName = "defaultdb";
        String userName = "avnadmin";
        String password = "AVNS_pSy0TkV7Fd2-R1s944x";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?sslmode=require", userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void closecon(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
