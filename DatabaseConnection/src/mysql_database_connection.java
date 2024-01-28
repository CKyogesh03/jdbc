import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysql_database_connection {
    public static void main(String[] args) throws SQLException {
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","password");
        System.out.println(c);
        System.out.println("connection established");
    }
}
