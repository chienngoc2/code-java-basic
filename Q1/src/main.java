
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        
        System.out.println("Enter desert:" );String dr = sc.nextLine();
        System.out.println("Enter step:" );int ds = sc.nextInt();
        Camel ca = new Camel(dr,ds);
        System.out.println("1.Test getDesert()");
        System.out.println("2.Test setStep");
        
        System.out.println("Enter TC(1 or 2) :");
        int n = sc.nextInt();
        if (n==1) {
            System.out.println(ca.getDesert());;
        } else if (n == 2) {
            int a = sc.nextInt();
            ca.setStep(a);
            System.out.println(ca.getStep());
            
        }
         sc.close();
    }

}
