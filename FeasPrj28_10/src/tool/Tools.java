package tool;

import data.CustomerList;
import data.FeastOrderList;
import java.util.List;
import java.util.Scanner;
import manager.Manager;
import manager.Customer;
import manager.Order;

public class Tools {

    private static Scanner sc = new Scanner(System.in);

    public static void exitAndSaveProgram() {
        System.out.println("You have unsaved changes. Do you want to save the changes? (Y/N)");
        String choice = sc.nextLine().trim().toUpperCase();

        if (choice.equals("Y")) {
            
            CustomerList cusList = CustomerList.readFromFile();

            //  Cập nhật danh sách khách hàng từ Manager
            List<Customer> updatedCustomers = Manager.getCustomerList();
            for (Customer updatedCustomer : updatedCustomers) {
                boolean found = false;
                for (int i = 0; i < cusList.size(); i++) {
                    if (cusList.get(i).getCustomerCode().equals(updatedCustomer.getCustomerCode())) {
                        cusList.set(i, updatedCustomer); // Cập nhật thông tin khách hàng cũ
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    cusList.add(updatedCustomer); // Thêm khách hàng mới nếu chưa có
                }
            }

            //  Ghi danh sách khách hàng mới vào file
            CustomerList.writeToFile(cusList);

            FeastOrderList orderList = FeastOrderList.readFromFile();  // Đọc danh sách cũ
            List<Order> updatedOrders = Manager.getOrderList(); // Lấy danh sách mới từ Manager

            for (Order updatedOrder : updatedOrders) {
                boolean found = false;
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getOrderID() == updatedOrder.getOrderID()) {
                        orderList.set(i, updatedOrder); // Cập nhật thông tin đơn hàng cũ
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    orderList.add(updatedOrder); // Thêm đơn hàng mới nếu chưa có
                }
            }

            FeastOrderList.writeToFile(orderList);  // Ghi danh sách mới vào file

            System.out.println("Changes have been saved.");
        } else if (choice.equals("N")) {
            System.out.println("Changes were not saved.");
        } else {
            System.out.println("Invalid choice. Returning to the main menu...");
            return;
        }

        //  Xác nhận nếu người dùng muốn thoát chương trình
        System.out.println("Are you sure you want to exit the program? (Y/N)");
        String confirmExit = sc.nextLine().trim().toUpperCase();
        if (confirmExit.equals("Y")) {
            System.out.println("Exiting the program...");
            System.exit(0);
        } else {
            System.out.println("Operation cancelled. Returning to the main menu...");
        }
    }

}
