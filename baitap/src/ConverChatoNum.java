
import java.util.Scanner;

public class ConverChatoNum {

    public static String converCha(int n) {
        switch (n) {
            case 1:
                return "Một";
            case 2:
                return "Hai";
            case 3:
                return "ba";
            case 4:
                return "bốn";
            default:
                return "IDK";
        }

    }
    public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("nhập number");
         int n = sc.nextInt();
         System.out.println("kết quả" + converCha(n));
         
} 
}
  
