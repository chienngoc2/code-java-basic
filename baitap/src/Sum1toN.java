import java.util.Scanner;
public class Sum1toN {

    public static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;

        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in)  ;
        int n = sc.nextInt();
        System.out.println("sum:=" + getSum(n));
    }
}
