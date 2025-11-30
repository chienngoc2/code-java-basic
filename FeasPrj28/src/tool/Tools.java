package tool;

import data.CustomerList;
import data.FeastOrderList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import manager.Manager;
import manager.Customer;
import manager.Order;

/**
 *
 * @author ADMIN
 */
public class Tools {

    private static Scanner sc = new Scanner(System.in);

    public static void exitAndSaveProgram() {
        System.out.println("You have unsaved changes. Do you want to save the changes? (Y/N)");
        String choice = sc.nextLine().trim().toUpperCase();

        if (choice.equals("Y")) {
            // Đọc danh sách khách hàng từ file
            CustomerList cusList = CustomerList.readFromFile();

            // Cập nhật danh sách khách hàng (thay thế khách hàng cũ nếu có)
            CustomerList cList = new CustomerList();
            cList.addAll(cusList);
            CustomerList.writeToFile(cList); // Lưu danh sách khách hàng

            // Đọc danh sách đơn hàng từ file
            FeastOrderList orderList = FeastOrderList.readFromFile();

            // Cập nhật danh sách đơn hàng (thay thế đơn hàng cũ nếu có)
            List<Order> updatedOrders = Manager.getOrderList();
            for (Order updatedOrder : updatedOrders) {
                int index = orderList.indexOf(updatedOrder);
                if (index != -1) {
                    orderList.set(index, updatedOrder); // Cập nhật đơn hàng cũ
                } else {
                    orderList.add(updatedOrder); // Thêm đơn hàng mới
                }
            }
            FeastOrderList.writeToFile(orderList); // Lưu danh sách đơn hàng

            System.out.println("Changes have been saved.");
        } else if (choice.equals("N")) {
            System.out.println("Changes were not saved.");
        } else {
            System.out.println("Invalid choice. Returning to the main menu...");
            return; // Quay lại menu chính
        }

        // Xác nhận nếu người dùng muốn thoát chương trình
        System.out.println("Are you sure you want to exit the program? (Y/N)");
        String confirmExit = sc.nextLine().trim().toUpperCase();
        if (confirmExit.equals("Y")) {
            System.out.println("Exiting the program...");
            System.exit(0); // Thoát chương trình
        } else {
            System.out.println("Operation cancelled. Returning to the main menu...");
        }
    }
}
