package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysqlDatabase {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //optional
        Connection c= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/jdbc_learning","root","password");

        System.out.println(c);
        System.out.println("connection established successfully");
    }
}