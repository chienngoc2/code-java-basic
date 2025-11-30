
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            openFIle();
            FileReader file = new FileReader("Data.txt");
            System.out.println("Found");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number");
            int n = sc.nextInt();
            System.out.println("n  = " + n);
            int result = 10 / n ;
            System.out.println("result = " + result);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (ArithmeticException e) {
            System.out.println("Ko chia được");
        // } catch (Exception e) {
         //   System.out.println("An error occurred");
        } finally {
            System.out.println("finally block");
        }
    }

    public static void openFIle() {
        try {
            readFile();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("Data.txt");
        System.out.println("file found");
    }

}
