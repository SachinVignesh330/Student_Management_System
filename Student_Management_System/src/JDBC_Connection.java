import java.sql.*;

public class JDBC_Connection {
    public static void main(String[] args) {
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_console", "root", "12102000");

            System.out.println("Connection Successful!");

            // Step 3: Closing the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

