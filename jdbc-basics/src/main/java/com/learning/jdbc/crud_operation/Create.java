package com.learning.jdbc.crud_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    public static void main(String[] args) throws SQLException {
        Connection c= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/jdbc_learning","root","password");

        Statement s= c.createStatement();
        s.executeUpdate("insert into employee values(1,'rahim','java developer',25000,2)");
        System.out.println("data inserted successfully");
    }
}
