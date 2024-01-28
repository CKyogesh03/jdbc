package com.learning.jdbc.crud_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) throws SQLException {
        Connection c= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/jdbc_learning","root","password");

        Statement s= c.createStatement();
        s.executeUpdate("delete from employee where eid=5");
        System.out.println("data deleted successfully");
    }
}