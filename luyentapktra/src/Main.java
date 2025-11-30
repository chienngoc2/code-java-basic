
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
           
     Scanner scanner = new Scanner(System.in);

        // Nhập thông tin nhân viên
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter seniority: ");
        int seniority = scanner.nextInt();

        // Khởi tạo đối tượng Employee
        Employee employee = new Employee(id, name, salary, seniority);

        // Hiển thị menu để chọn test case
        System.out.println("1. Test setSeniority()");
        System.out.println("2. Test updateSalary()");
        System.out.print("Enter TC (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter new seniority: ");
            int newSeniority = scanner.nextInt();
            employee.setSeniority(newSeniority);
        } else if (choice == 2) {
            employee.updateSalary();
        }

        // Hiển thị kết quả
        System.out.println("OUTPUT:");
        System.out.println(employee.toString());

        scanner.close();
    }
}

    
   
