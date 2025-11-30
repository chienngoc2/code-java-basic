
package q2luyentap;
 import java.util.Scanner;
public class q2 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        // Getting user input
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter power: ");
        int power = sc.nextInt();
        sc.nextLine();  // Consume newline left-over

        System.out.print("Enter sound: ");
        String sound = sc.nextLine();

        // Creating an instance of SpecSpeaker
        SpecSpeaker specSpeaker = new SpecSpeaker(name, power, sound);
        Speaker specker = new Speaker(name,power);
        // Display options
        System.out.println("1. Test toString()");
        System.out.println("2. Test setData()");
        System.out.println("3. Test getValue()");
        System.out.print("Enter TC {1,2,3}: ");
        int choice = sc.nextInt();

        // Test cases
        switch (choice) {
            case 1:
                // Test toString method
                System.out.println("OUTPUT:");
                System.out.println(specker.toString());
                break;
            case 2:
                // Test setData method
                specSpeaker.setData();
                System.out.println("OUTPUT:");
                System.out.println(specSpeaker.getName() + ", " + specSpeaker.getPower());
                break;
            case 3:
                // Test getValue method
                System.out.println("OUTPUT:");
                System.out.println(specSpeaker.getValue());
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
 
