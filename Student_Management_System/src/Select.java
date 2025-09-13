import java.sql.*;

public class Select {
    public static void select_student(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_console", "root", "12102000")) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_info");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                String email = rs.getString("email");

                System.out.println(id + " | " + name + " | " + age + " | " + course + " | " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
