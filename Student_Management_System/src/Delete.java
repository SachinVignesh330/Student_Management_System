import java.sql.*;
import java.util.Scanner;

public class Delete {
    public static void delete_student(String [] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_console", "root", "12102000");
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the ID of the student to delete: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM students_info WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, id);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student with ID " + id + " deleted successfully.");
                } else {
                    System.out.println("No student found with ID " + id);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
