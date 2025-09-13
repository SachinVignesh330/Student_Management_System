import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void insert_student(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_console", "root", "12102000");
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter student course: ");
            String course = scanner.nextLine();

            System.out.print("Enter student email: ");
            String email = scanner.nextLine();

            String sql = "INSERT INTO students_info (name, age, course, email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, course);
                pstmt.setString(4, email);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student added successfully.");
                } else {
                    System.out.println("Insert failed.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

