
package luyentap;

import java.util.Scanner;

public class Luyentap {

    public static void main(String[] args) {
      
            Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu từ người dùng
        System.out.print("Enter owner: ");
        String owner = sc.nextLine();

        System.out.print("Enter weight: ");
        int weight = sc.nextInt();

        // Tạo đối tượng Zebra
        Zebra zebra = new Zebra(owner, weight);

        // Chọn chức năng để kiểm tra
        System.out.println("1. Test getOwner()");
        System.out.println("2. Test setWeight()");
        System.out.print("Enter TC (1 or 2): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("OUTPUT: " + zebra.getOwner());
        } else if (choice == 2) {
            System.out.print("Enter new weight: ");
            int newWeight = sc.nextInt();
            zebra.setWeight(newWeight);
            System.out.println("OUTPUT: " + zebra.getWeight());
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    
    }
    
}
