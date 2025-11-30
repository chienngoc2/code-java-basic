/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucll_bcnn_prime;

// MathUtils.java
public class MathUtils {

    // Phương thức tính UCLN của hai số a và b
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Phương thức tính BCNN của hai số a và b
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b); // Dùng công thức: a * b = gcd(a, b) * lcm(a, b)
    }

    // Phương thức kiểm tra xem một số có phải là số nguyên tố hay không
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
     public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
     public static boolean isPalindrome(String str) {
        // Loại bỏ khoảng trắng và chuyển chuỗi về chữ thường để kiểm tra
        str = str.replaceAll("\\s+", "").toLowerCase();

        // Dùng hai con trỏ để kiểm tra từng cặp ký tự từ đầu và cuối chuỗi
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Nếu có một cặp không trùng khớp, không phải palindrome
            }
            left++;
            right--;
        }

        return true; // Nếu tất cả các cặp đều khớp, là palindrome
    }
}
