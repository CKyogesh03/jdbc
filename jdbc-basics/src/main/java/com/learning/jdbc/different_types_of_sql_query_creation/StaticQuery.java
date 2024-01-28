package com.learning.jdbc.different_types_of_sql_query_creation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/jdbc_learning","root","password");

        Statement s= c.createStatement();
        boolean isUpdated=s.execute("update employee set name='jack',job='selenium' where id=6");
        System.out.println("data updated successfully");
        System.out.println(isUpdated); //false bcoz
    }
}
