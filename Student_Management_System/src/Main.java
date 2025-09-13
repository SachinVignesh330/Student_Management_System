import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> Insert.insert_student(null);
                case 2 -> Select.select_student(null);
                case 3 -> Update.update_student(null);
                case 4 -> Delete.delete_student(null);
                case 5 -> {
                    quit = true;
                    System.out.println("Byeeee....");
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }

        scanner.close();
    }
}
