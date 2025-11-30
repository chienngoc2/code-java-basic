
package ReplaceXXvaoVitri;
import java.util.Scanner;

public class Baitap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter owner: ");
        String owner = sc.nextLine();

        System.out.print("Enter price: ");
        int price = sc.nextInt();

        System.out.print("Enter color: ");
        int color = sc.nextInt();

        // Create SpecCala object
        SpecCala specCala = new SpecCala(color, owner, price);

        // Menu options
        System.out.println("1. Test toString()");
        System.out.println("2. Test setData()");
        System.out.println("3. Test getValue()");
        System.out.print("Enter TC(1,2,3): ");
        int choice = sc.nextInt();

        // Execute based on user input
        switch (choice) {
            case 1:
                // Test toString()
                System.out.println(specCala.toString());
                break;
            case 2:
                // Test setData()
                specCala.setData();  // Modify owner
                System.out.println(specCala.getOwner());
                System.out.println(specCala.getPrice());
                break;
            case 3:
                // Test getValue()
                specCala.setData();  // Modify owner first
                System.out.println("Value: " + specCala.getValue());
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
