package tool;

import data.CustomerList;
import data.FMenuList;
import data.FeastOrderList;
import java.time.format.DateTimeFormatter;
import manager.Customer;
import manager.Order;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import manager.Feast;
import manager.Manager;

public class Display {

    private static final DateTimeFormatter formatterVN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void displayMenu() {
        System.out.println("----------------------------------------------------");
        System.out.println("|            DISPLAY CUSTOMER OR ORDER LIST       |");
        System.out.println("----------------------------------------------------");
        System.out.println("| 1. Display Customers List                       |");
        System.out.println("| 2. Display Orders List                          |");
        System.out.println("| 3. Return to Main Menu                          |");
        System.out.println("----------------------------------------------------");
    }

    public static void displayCustomerList() {
        CustomerList customerList = CustomerList.readFromFile();

        if (customerList.isEmpty()) {
            System.out.println("No customer data available.");
            return;
        }

        // Sắp xếp danh sách khách hàng theo tên
        customerList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        System.out.println("Customers information:");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-16s | %-15s | %-15s |\n", "Code", "Customer Name", "Phone", "Email");
        System.out.println("-----------------------------------------------------------------------------");

        for (Customer c : customerList) {
            System.out.printf("| %-15s | %-16s | %-15s | %-15s |\n",
                    c.getCustomerCode(), Manager.formatName(c.getName()), c.getPhone(), c.getEmail());
        }
        System.out.println("--------------------------------------------------------------");
    }
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void displayOrderList() {
        FeastOrderList orderList = FeastOrderList.readFromFile();

        if (orderList.isEmpty()) {
            System.out.println("No order data available.");
            return;
        }

        // Sắp xếp danh sách đơn hàng theo ngày tổ chức (tăng dần)
        orderList.sort((d1, d2) -> d1.getEventDate().compareTo(d2.getEventDate()));

        // Đọc danh sách thực đơn từ file để lấy giá menu
        FMenuList feastMenu = FMenuList.readFromFile();

        System.out.println("Orders information:");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-10s | %-11s | %-7s | %-10s | %-6s | %-10s |\n",
                "ID", "Event Date", "Customer ID", "Menu", "Price", "Tables", "Cost");
        System.out.println("-------------------------------------------------------------------------------");

        for (Order o : orderList) {
            String formattedDate = o.getEventDate().format(formatterVN);

            // Lấy giá của menu từ danh sách thực đơn
            Feast feast = feastMenu.getFeastByCode(o.getFeastCode());
            int menuPrice = (feast != null) ? feast.getFeastPrice() : 0;

            System.out.printf("| %-6s | %-10s | %-11s | %-7s | %,10d | %-6d | %,10d |\n",
                    o.getOrderID(), formattedDate, o.getCustomerCode(),
                    o.getFeastCode(), menuPrice, o.getNumberOfTables(), o.getTotalCost());
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

}
