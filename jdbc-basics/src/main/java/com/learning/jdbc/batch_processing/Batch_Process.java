package com.learning.jdbc.batch_processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
//pending
public class Batch_Process {
    public static void main(String[] args) {
        Connection c=null; // to access globally in try and catch block

        Scanner s=new Scanner(System.in);
        System.out.println("enter how many datas you want to insert");
        int count=s.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","password");

            PreparedStatement ps=c.prepareStatement("insert into employees values (?, ?, ?, ?, ?)");


            for(int i=1;i<=count;i++) {
                System.out.print("Enter employee id : ");
                int eid=s.nextInt();

                System.out.print("Enter employee name : ");
                String ename=s.next();

                System.out.print("Enter employee designation : ");
                String designation=s.next();

                System.out.print("Enter employee salary : ");
                double salary=s.nextDouble();

                System.out.print("Enter employee's manager id : ");
                int mgrid=s.nextInt();

                ps.setInt(1,eid);
                ps.setString(2, ename);
                ps.setString(3, designation);
                ps.setDouble(4, salary);
                ps.setInt(5, mgrid);

                ps.addBatch(); //it adds every group of query in a single batch in a seperate memory .addUpdate() interact with db every time. so we go for addBatch().
                System.out.println("data added into batch succesfully");
            }
            ps.executeBatch(); //it interact with db 1 time only and execute more queries present.
            System.out.println("data saved in db succesfully");
        }
        catch(ClassNotFoundException | SQLException e) {

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
