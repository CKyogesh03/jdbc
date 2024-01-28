import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver class present in
        //forName() - this method throws ClassNotFoundException. it is a checked exception
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","password");
        //note: we can't create database using url in jdbc but allowed in hibernate.
        //getConnection(url,user,pass) - throws SQLException. it is checked exception
        System.out.println("Connection successful");

    }
}