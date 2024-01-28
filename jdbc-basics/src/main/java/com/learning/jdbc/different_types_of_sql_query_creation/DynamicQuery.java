package com.learning.jdbc.different_types_of_sql_query_creation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DynamicQuery {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc_learning","root","password");

                System.out.print("Enter employee id : ");
                int id=s.nextInt();

                System.out.print("Enter employee name : ");
                String name=s.next();

                System.out.print("Enter employee job : ");
                String job=s.next();

                System.out.print("Enter employee salary : ");
                double salary=s.nextDouble();

                System.out.print("Enter employee's manager id : ");
                int manager_id=s.nextInt();

                //DYNAMIC INSERT
                PreparedStatement ps=c.prepareStatement("insert into employee values (?, ?, ?, ?, ?)");
                ps.setInt(1,id);
                ps.setString(2, name);
                ps.setString(3, job);
                ps.setDouble(4, salary);
                ps.setInt(5, manager_id);

                ps.executeUpdate();
                System.out.println("data saved succesfully");

        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
