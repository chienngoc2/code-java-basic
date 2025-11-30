package manager;

import data.CustomerList;
import data.FMenuList;
import data.FeastOrderList;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import tool.Inputter;
import tool.Tools;
import tool.Acceptable;
import tool.VietnameseUtils;

public class Manager {

    private final DateTimeFormatter formatterVN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private Scanner sc = new Scanner(System.in);
    public static List<Customer> cList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        return cList;
    }

    public String getCampusPrefix() {
        System.out.println("Choose prefit 1 -> 3 (C|G|K): ");
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Valid choice (1->3)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.Please enter a number (1->3)");
            }
        }

        switch (choice) {
            case 1:
                return "C";

            case 2:
                return "G";
            case 3:
                return "K";

            default:
                return "/n";
        }

    }
    //tạo ds dki sau khi đã biết mountainList

    public void addCustomer() {

        String prefit = getCampusPrefix();
        String cusCode = Inputter.getID(prefit);
        String name = Inputter.getName();
        String email = Inputter.getEmail(cList);
        String phone = Inputter.getNumPhone(cList);
        Customer infoReg = new Customer(cusCode, name, phone, email);
        System.out.println(infoReg.toString());
        cList.add(infoReg);

        Tools.exitAndSaveProgram(); //tool lưu và thoát

        System.out.println("New registration has been added successfully!");
    }

    public static Customer getCustomer(String id, List<Customer> sList) {
        for (Customer s : sList) {
            if (s.getCustomerCode().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void updateCustomer() {
        CustomerList cList = CustomerList.readFromFile(); // Đọc danh sách hiện tại từ file

        System.out.println("Enter Customer Code: ");
        String idCode = sc.nextLine().toUpperCase().trim();
        while (!Acceptable.isValid(idCode, Acceptable.CUS_CODE_VALID)) { // Kiểm tra cú pháp mã khách hàng
            idCode = Inputter.getString("Please enter a valid customer code:");
        }

        Customer customer = Manager.getCustomer(idCode, cList); // Tìm khách hàng theo mã
        if (customer == null) {
            System.out.println("This customer does not exist. Please try again.");
            return;
        }

        // Hiển thị thông tin khách hàng trước khi cập nhật
        System.out.println("Current information");
        System.out.println("-----------------------------------------------------");
        System.out.printf("Code: %s\n", customer.getCustomerCode());
        System.out.printf("Name : %s\n", customer.getName());
        System.out.printf("Phone : %s\n", customer.getPhone());
        System.out.printf("Email : %s\n", customer.getEmail());
        System.out.println("-----------------------------------------------------");

        // Nhập thông tin mới
        String name = Inputter.getName();
        String email = Inputter.getEmail(cList);
        String phone = Inputter.getNumPhone(cList);

        // Cập nhật thông tin trong danh sách
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

        // Ghi danh sách mới vào file
        CustomerList.writeToFile(cList);
        System.out.println("The customer's information has been successfully updated.");
    }

    public void searchCusByName() {

        cList = CustomerList.readFromFile();

        String searchName = Inputter.getName().toLowerCase().trim(); // dùng static để nhập & ktra cú pháp name
        List<Customer> matching = new ArrayList<>();  // tạo list mới để chứa student có tên cần tìm
        for (Customer s : cList) {

            if (s.getName().toLowerCase().contains(searchName)) {
                matching.add(s);
            }
        }
        if (matching.isEmpty()) {
            System.out.println("No one matches the search criteria!");

        } else {

            // Hiển thị danh sách sinh viên phù hợp
            System.out.println("Matching :" + searchName);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-12s | %-20s | %-15s | %-15s%n",
                    "Code", "Name", "Phone", "Email");
            System.out.println("-------------------------------------------------------------------------------");

            // In ra thông tin của mỗi sinh viên trong danh sách matchingStudents
            for (Customer cus : matching) {
                String name = formatName(cus.getName());
                System.out.printf("%-12s | %-20s | %-15s | %-15s%n",
                        cus.getCustomerCode(), name, cus.getPhone(), cus.getEmail());
            }
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static String formatName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length < 2) {
            return fullName;
        }
        String firstName = parts[parts.length - 1];
        String lastName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

        return firstName + ", " + lastName;
    }
//---------------------------------------------------------------------------------------------------------------------
    //=================================================================================================================

    public static void displayFeastMenu() {

        FMenuList feastMenu = FMenuList.readFromFile();

        if (feastMenu.isEmpty()) {
            System.out.println("Cannot read data from feastMenu.csv. Please check it.");
            return;
        }

        //Collections.sort(feastMenu, (f1, f2) -> Integer.compare(f1.getFeastPrice(), f2.getFeastPrice()));
        // Hiển thị tiêu đề bảng
        System.out.println("========================================================================================================");
        System.out.println("                                   FEAST MENU LIST             ");
        System.out.println("========================================================================================================");

        // Hiển thị từng thực đơn
        for (Feast feast : feastMenu) {
            System.out.println(feast);
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("                                                                                                     ");
        }

        System.out.println("End of menu.");
    }
//--------------------------------------------------------------------------------------------------------
    //====================================================================================================
    private static List<Order> orderList = new ArrayList<>(); // Danh sách đơn đặt hàng

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void placeFeastOrder() {
        System.out.println("========== PLACE A FEAST ORDER ==========");

        // Đọc danh sách khách hàng và thực đơn từ file trước khi nhập
        CustomerList cusList = CustomerList.readFromFile();

        if (cusList == null) {
            System.out.println("Error reading customer list from file!");
            return;
        }

        FMenuList feastMenu = FMenuList.readFromFile();
        if (feastMenu == null) {
            System.out.println("Error reading feast menu list from file!");
            return;
        }

        // Nhập mã khách hàng và kiểm tra hợp lệ
        String customerCode;
        Customer customer = null;
        do {
            customerCode = Inputter.getString("Enter Customer Code: ").trim();

            if (!Acceptable.isValid(customerCode, Acceptable.CUS_CODE_VALID)) {
                System.out.println("Invalid format! Customer code must start with C, K, or G.");
                continue;
            }

            customer = cusList.getCusByCode(customerCode);
            if (customer == null) {
                System.out.println("Customer not found! Please try again.");
            }
        } while (customer == null);
        displayFeastMenu();
        // Nhập mã thực đơn và kiểm tra hợp lệ
        String menuCode;
        Feast feast = null;
        do {
            menuCode = Inputter.getString("Enter Set Menu Code: ").toUpperCase().trim();
            feast = feastMenu.getFeastByCode(menuCode);
            if (feast == null) {
                System.out.println("Invalid Set Menu Code! Please try again.");
            }
        } while (feast == null);

        // Nhập số bàn (phải > 0)
        int numberOfTables;
        do {
            numberOfTables = Inputter.getInt("Enter number of tables: ", 1, 10000);
            if (numberOfTables <= 0) {
                System.out.println("Number of tables must be greater than zero!");
            }
        } while (numberOfTables <= 0);

        // Nhập ngày tổ chức tiệc (phải là ngày trong tương lai)
        LocalDate eventDate = Inputter.getDate("Enter event date (DD-MM-YYYY): ");

        // Kiểm tra đơn hàng trùng lặp
        for (Order o : orderList) {
            if (o.getCustomerCode().equals(customerCode)
                    && o.getFeastCode().equals(menuCode)
                    && o.getEventDate().equals(eventDate)) {
                System.out.println("Duplicate data! This order already exists.");
                return;
            }
        }
        if (isDuplicateData(customerCode, menuCode, eventDate)) {
            return;
        }

        // Tạo đơn hàng hợp lệ
        int orderID = orderList.size() + 1;
        int totalCost = numberOfTables * feast.getFeastPrice();
        Order newOrder = new Order(orderID, customerCode, menuCode, numberOfTables, eventDate, totalCost);
        orderList.add(newOrder);

        // Hiển thị đơn hàng đã đặt
        System.out.println("\n==========================================");
        System.out.println(" Customer order information [Order ID: " + orderID + "]");
        System.out.println("==========================================");
        System.out.println("Code          : " + customer.getCustomerCode());
        System.out.println("Customer name : " + formatName(customer.getName()));
        System.out.println("Phone number  : " + customer.getPhone());
        System.out.println("Email         : " + customer.getEmail());
        System.out.println("------------------------------------------");
        System.out.println("Code of Set Menu  : " + feast.getFeastCode());
        System.out.println("Set menu name     : " + feast.getFeastName());
        System.out.println("Event date        : " + eventDate);
        System.out.println("Number of tables  : " + numberOfTables);
        System.out.printf("Price             : %,d Vnd\n", feast.getFeastPrice());
        System.out.println("Ingredients       : " + feast.getFeastIngredients().replace("#", "\n+ "));
        System.out.println("------------------------------------------");
        System.out.printf("Total cost        : %,d Vnd\n", totalCost);
        System.out.println("==========================================");

        FeastOrderList feastOrderList = new FeastOrderList();
        feastOrderList.addAll(orderList); // Chuyển dữ liệu từ orderList vào FeastOrderList
        FeastOrderList.writeToFile(feastOrderList); // Lưu danh sách vào file

    }
//-----------------------------------------------------------------------------------------------------------------------   
//=======================================================================================================================

    public static boolean isDuplicateData(String customerOrderCode, String codeOfSetMenus, LocalDate bookedDate) {
        for (Order order : orderList) {
            if (order.getCustomerCode().equals(customerOrderCode)
                    && order.getFeastCode().equals(codeOfSetMenus)
                    && order.getEventDate().equals(bookedDate)) {
                System.out.println("Duplicate data!");
                return true;
            }
        }
        return false;
    }

//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
    public static void updateOrder() {
        FeastOrderList orderList = FeastOrderList.readFromFile();
        System.out.println("========== UPDATE ORDER INFORMATION ==========");

        // Nhập Order ID
        int orderID = Inputter.getInt("Enter Order ID to update: ", 1, orderList.size());
        Order orderToUpdate = null;

        // Tìm kiếm đơn hàng trong danh sách
        for (Order o : orderList) {
            if (o.getOrderID() == orderID) {
                orderToUpdate = o;
                break;
            }
        }

        // Nếu đơn hàng không tồn tại
        if (orderToUpdate == null) {
            System.out.println("This Order does not exist.");
            return;
        }

        // Nếu ngày tổ chức đã qua, không cho phép cập nhật
        if (orderToUpdate.getEventDate().isBefore(LocalDate.now())) {
            System.out.println("Cannot update an order whose event date has already passed!");
            return;
        }

        // Hiển thị thông tin cũ
        System.out.println("Current Order Information:");
        System.out.println(orderToUpdate);

        // Đọc danh sách thực đơn từ file
        FMenuList feastMenu = FMenuList.readFromFile();

        // Nhập mã Set Menu mới (có thể giữ nguyên)
        String newMenuCode = Inputter.getString("Enter new Set Menu Code (press Enter to keep current): ").toUpperCase().trim();
        if (!newMenuCode.isEmpty()) {
            Feast newFeast = feastMenu.getFeastByCode(newMenuCode);
            if (newFeast == null) {
                System.out.println("Invalid Set Menu Code! Keeping current menu.");
            } else {
                orderToUpdate.setFeastCode(newMenuCode);
            }
        }

        // Nhập số bàn mới (có thể giữ nguyên)
        while (true) {
            String tableInput = Inputter.getString("Enter new number of tables (press Enter to keep current): ").trim();
            if (tableInput.isEmpty()) {
                break; // Giữ nguyên số bàn hiện tại
            }
            try {
                int newTableCount = Integer.parseInt(tableInput);
                if (newTableCount > 0) {
                    orderToUpdate.setNumberOfTables(newTableCount);
                    break;
                } else {
                    System.out.println("Invalid table count! Number must be greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        // Nhập ngày tổ chức mới (có thể giữ nguyên)
        while (true) {
            String dateInput = Inputter.getString("Enter new event date (DD-MM-YYYY) (press Enter to keep current): ").trim();
            if (dateInput.isEmpty()) {
                break; // Giữ nguyên ngày cũ
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate newDate = LocalDate.parse(dateInput, formatter);
                if (newDate.isAfter(LocalDate.now())) {
                    orderToUpdate.setEventDate(newDate);
                    break;
                } else {
                    System.out.println("Invalid date! Event date must be in the future.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please enter in DD-MM-YYYY format.");
            }
        }

        // Tính lại tổng tiền nếu Set Menu thay đổi
        Feast updatedFeast = feastMenu.getFeastByCode(orderToUpdate.getFeastCode());
        if (updatedFeast != null) {
            orderToUpdate.setTotalCost(orderToUpdate.getNumberOfTables() * updatedFeast.getFeastPrice());
        }

        // Hiển thị thông tin cập nhật
        System.out.println("\nUpdated Order Information:");
        System.out.println(orderToUpdate);
        System.out.println("Order updated successfully!");

        // Lưu danh sách đơn hàng vào file sau khi cập nhật
        FeastOrderList feastOrderList = new FeastOrderList();
        feastOrderList.addAll(orderList);
        FeastOrderList.writeToFile(feastOrderList);

        Tools.exitAndSaveProgram();
    }

    public void deleteCustomer() {
        CustomerList cList = CustomerList.readFromFile(); // Đọc danh sách khách hàng từ file

        System.out.println("Enter Customer Code: ");
        String idCode = sc.nextLine().toUpperCase().trim();
        while (!Acceptable.isValid(idCode, Acceptable.CUS_CODE_VALID)) { // Kiểm tra cú pháp mã khách hàng
            idCode = Inputter.getString("Please enter a valid customer code:");
        }

        Customer customer = Manager.getCustomer(idCode, cList); // Tìm khách hàng theo mã
        if (customer == null) {
            System.out.println("This customer does not exist. Please try again.");
            return;
        }

        // Hiển thị thông tin khách hàng trước khi xóa
        System.out.println("Customer Details:");
        System.out.println("------------------------------------------------");
        System.out.printf("Customer Code: %s\n", customer.getCustomerCode());
        System.out.printf("Name : %s\n", customer.getName());
        System.out.printf("Phone : %s\n", customer.getPhone());
        System.out.printf("Email : %s\n", customer.getEmail());
        System.out.println("------------------------------------------------");

        String confirm = Inputter.getString("Are you sure you want to delete this customer? (Y/N): ");
        if (confirm.equalsIgnoreCase("Y")) {
            cList.remove(customer); // Xóa khách hàng khỏi danh sách

            CustomerList.writeToFile(cList); // Lưu danh sách sau khi xóa
            System.out.println("The customer has been successfully deleted.");
        } else {
            System.out.println("Operation cancelled. Returning to the main menu.");
        }

    }

    public void displayCustomerList() {
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

    public void displayOrderList() {
        FeastOrderList orderList = FeastOrderList.readFromFile();

        if (orderList.isEmpty()) {
            System.out.println("No order data available.");
            return;
        }

        // Sắp xếp danh sách đơn hàng theo ngày tổ chức (tăng dần)
        //orderList.sort((d1, d2) -> d1.getEventDate().compareTo(d2.getEventDate()));
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

    public void deleteOrderByID() {
        System.out.println("========== DELETE ORDER ==========");

        // Đọc danh sách đơn hàng từ file
        FeastOrderList orderList = FeastOrderList.readFromFile();
        if (orderList == null || orderList.isEmpty()) {
            System.out.println("No orders found!");
            return;
        }

        // Nhập ID cần xóa
        int orderID = Inputter.getInt("Enter Order ID to delete: ", 1, Integer.MAX_VALUE);

        // Tìm đơn hàng theo ID
        Order orderToDelete = null;
        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                orderToDelete = order;
                break;
            }
        }

        // Kiểm tra nếu tìm thấy đơn hàng
        if (orderToDelete != null) {
            // Xác nhận trước khi xóa
            String confirm = Inputter.getString("Are you sure you want to delete this order? (Y/N): ").toUpperCase();
            if (confirm.equals("Y")) {
                orderList.remove(orderToDelete); // Xóa order khỏi danh sách
                FeastOrderList.writeToFile(orderList); // Lưu danh sách mới vào file
                System.out.println("Order deleted successfully.");
            } else {
                System.out.println("Operation cancelled.");
            }
        } else {
            System.out.println("Order ID not found!");
        }
    }

    public void searchByIngerdiants() {
    FMenuList menu = FMenuList.readFromFile();

    System.out.print("Enter ingredient to search: ");
    String searchName = sc.nextLine().toLowerCase().trim();
    
    // Chuyển về không dấu để so sánh
    String searchNameNoDiacritics = VietnameseUtils.removeDiacritics(searchName);

    List<Feast> matching = new ArrayList<>();
    for (Feast s : menu) {
        String ingredientsNoDiacritics = VietnameseUtils.removeDiacritics(s.getFeastIngredients().toLowerCase());

        if (ingredientsNoDiacritics.contains(searchNameNoDiacritics)) {
            matching.add(s);
        }
    }

    if (matching.isEmpty()) {
        System.out.println("No ingredients match your search criteria!");
    } else {
        System.out.println("========================================================================================================");
        System.out.println("                                   FEAST MENU LIST             ");
        System.out.println("========================================================================================================");

        for (Feast feast : matching) {
            System.out.println(feast);
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }
}

    

}
