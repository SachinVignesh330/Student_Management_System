import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void update_student(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_console", "root", "12102000");
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the ID of the student to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new course: ");
            String course = scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            String sql = "UPDATE students_info SET name = ?, age = ?, course = ?, email = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, course);
                pstmt.setString(4, email);
                pstmt.setInt(5, id);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student with ID " + id + " updated successfully.");
                } else {
                    System.out.println("No student found with ID " + id);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
