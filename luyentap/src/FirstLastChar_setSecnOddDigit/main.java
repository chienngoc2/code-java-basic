package FirstLastChar_setSecnOddDigit;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyString myString = new MyString();

        // Choose the test case (f1 or f2)
        System.out.println("Enter TC (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        if (choice == 1) {
            // Call f1 and display the output
            int result = myString.f1(input);
            System.out.println("OUTPUT: " + result);
        } else if (choice == 2) {
            // Call f2 and display the output
            String result = myString.f2(input);
            System.out.println("OUTPUT: " + result);
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
