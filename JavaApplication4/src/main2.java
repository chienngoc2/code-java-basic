/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class Main2 {
    public static void main2(String[] args) {
        // In ra thông báo chào mừng
        System.out.println("Hello, World!");

        // Tạo đối tượng Scanner để nhận dữ liệu từ người dùng
        Scanner sc = new Scanner(System.in);

        // Yêu cầu người dùng nhập vào một số
        System.out.print("Nhập vào một cạnh: ");
        
        // Đọc giá trị kiểu double từ người dùng
        double slide1 = sc.nextDouble();

        // In ra giá trị mà người dùng đã nhập
        System.out.println("Bạn đã nhập: " + slide1);

        // Đóng Scanner để tránh rò rỉ tài nguyên
        sc.close();
    }
}


