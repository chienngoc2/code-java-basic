package model;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose your Campus:");
        System.out.println("1. SE");
        System.out.println("2. HE");
        System.out.println("3. QE");
        System.out.println("4. DE");
        System.out.println("5. SE");
        System.out.println("Your choice: ");
        int choice = scanner.nextInt();
        do {
            System.out.println("Please enter a valid choice: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 5);

        String campusName = getCampusName(choice);

        System.out.println("Your campus is: " + campusName);

        String studentId = getStudentId(campusName);
        System.out.println("id is: " + studentId);
        System.out.println("Please enter your name: ");
        String name = "";
        do {
            System.out.println("nhap lai ten di may: ");
            name = scanner.next();
        } while (!isValidName(name));

        System.out.println("Please enter your email: ");
        String email = "";

        do {
            System.out.println("nhap lai mail di may: ");
            email = scanner.next();
        } while (!isValidEmail(email));

        System.out.println("Please enter your phone: ");
        String phone = scanner.next();
        System.out.println("Please enter your mountain code: ");
        String mountainCode = scanner.next();
        System.out.println("Please enter your tuition fee: ");
        String tuitionFee = scanner.next();

        Student student = new Student(studentId, tuitionFee, mountainCode, phone, email, name);
        System.out.println("Student information: ");
        System.out.println(student.toString());

    }

    static String getCampusName(int choice) {
        switch (choice) {
            case 1:
                return "SE";
            case 2:
                return "HE";
            case 3:
                return "QE";
            case 4:
                return "DE";
            case 5:
                return "SE";
            default:
                return "Invalid choice";
        }
    }

    static String getStudentId(String campusName) {
        String id = UUID.randomUUID().toString();
        return campusName + "_" + id;
    }

    static boolean isValidName(String name) {
        if (name == null || name.isEmpty() || name.length() < 2 || name.length() > 20) {
            return false;
        }
        return true;
    }

    static boolean isValidEmail(String email) {
        if (email.isEmpty() || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return false;
        }
        return true;
    }
}
