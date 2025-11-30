
package interfacedemo1;
import java.util.Scanner;

public class InterfaceDemo1 {

    



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyUtilities myUtilities = new MyUtilities();
        System.out.println("1.Test reverseNumber");
        System.out.println("2.Test countSpecialCharacter");
        System.out.print("Enter TC (1 | 2): ");
        int tc = Integer.parseInt(scanner.nextLine());
        switch (tc) {
            case 1:
                System.out.print("Enter n: ");
                int n = Integer.parseInt(scanner.nextLine());
                System.out.println("OUTPUT:");
                System.out.println(myUtilities.reverseNumber(n));
                break;
            case 2:
                System.out.print("Enter s: ");
                String s = scanner.nextLine();
                System.out.println("OUTPUT:");
                System.out.println(myUtilities.countSpecialCharacter(s));
                break;
        }
    }
}

    

