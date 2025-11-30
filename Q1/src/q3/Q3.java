package q3;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để nhận dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập place
        System.out.print("Enter place: ");
        String place = scanner.nextLine();

        // Nhập area
        System.out.print("Enter area: ");
        int area = scanner.nextInt();
        scanner.nextLine();  // Tiêu thụ ký tự xuống dòng sau khi nhập số

        // Nhập color
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        // Tạo đối tượng SpecWall
        Wall wall = new Wall(place, area);
        SpecWall specWall = new SpecWall(place, area, color);

        // Hiển thị lựa chọn kiểm thử
        System.out.println("1. Test toString()");
        System.out.println("2. Test setData()");
        System.out.println("3. Test getValue()");

        // Nhập lựa chọn
        System.out.print("Enter TC (1,2,3): ");
        int choice = scanner.nextInt();

        // Thực thi theo lựa chọn của người dùng
        switch (choice) {
            case 1:
                // Kiểm thử toString()
                System.out.println(wall.toString());
                System.out.println(specWall.toString());
                break;
            case 2:
                // Kiểm thử setData()
                specWall.setData();
                System.out.println(  specWall.getPlace());  // In ra place đã được cập nhật
                System.out.println(  specWall.getArea());
                break;
            case 3:
                // Kiểm thử getValue()
                System.out.println(specWall.getValue());
                break;
            default:
                System.out.println("Invalid choice");
        }

        // Đóng Scanner
        scanner.close();
    }
}
