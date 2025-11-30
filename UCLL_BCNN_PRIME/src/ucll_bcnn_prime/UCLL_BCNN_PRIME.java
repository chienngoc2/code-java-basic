
package ucll_bcnn_prime;
  import java.util.Scanner;
public class UCLL_BCNN_PRIME {

   
    public static void main(String[] args) {
    

        Scanner scanner = new Scanner(System.in);

        // Nhập hai số nguyên từ người dùng
        System.out.print("Nhập số thứ nhất: ");
        int num1 = scanner.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();

        // Tính UCLN và BCNN của hai số
        int gcd = MathUtils.gcd(num1, num2);
        int lcm = MathUtils.lcm(num1, num2);

        // Kiểm tra tính nguyên tố của hai số
        boolean isNum1Prime = MathUtils.isPrime(num1);
        boolean isNum2Prime = MathUtils.isPrime(num2);

        // In kết quả
        System.out.println("UCLN của " + num1 + " và " + num2 + " là: " + gcd);
        System.out.println("BCNN của " + num1 + " và " + num2 + " là: " + lcm);

        System.out.println(num1 + (isNum1Prime ? " là số nguyên tố." : " không là số nguyên tố."));
        System.out.println(num2 + (isNum2Prime ? " là số nguyên tố." : " không là số nguyên tố."));
        
        scanner.close();
    }
}
    