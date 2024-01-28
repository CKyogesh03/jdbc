package com.learning.jdbc.crud_operation;

import java.sql.*;

public class Read {
    public static void main(String[] args) {
        Connection c=null; // to access globally in try and catch block
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc_learning","root","password");

            Statement s=c.createStatement();
            ResultSet rs= s.executeQuery("select * from employee");

            while(rs.next()) {
                System.out.print("id= "+rs.getInt(1) + ", ");
                System.out.print("name= "+rs.getString("name")+ ", ");
                System.out.print("job= "+rs.getString(3)+ ", ");
                System.out.print("salary= "+rs.getDouble(4)+ ", ");
                System.out.print("manager id= "+rs.getInt(5));
                System.out.println();

            }
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println("handled exception");
        }
        finally {
            try {
                c.close(); // this method throws SQLException
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
