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

public class Manager {

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
        cList = CustomerList.readFromFile();

        System.out.println("Enter Customer Code code: ");
        String idCode = sc.nextLine().toUpperCase().trim();
        while (!Acceptable.isValid(idCode, Acceptable.CUS_CODE_VALID)) { // nếu sai cú pháp nhập lại
            System.out.println("Please enter a valid  code.");
            idCode = sc.nextLine();
        }
        Customer customer = getCustomer(idCode, cList); // tìm sinh viên dựa trên id
        if (customer == null) {
            System.out.println("This customer has not registered yet. Please try again.");
        } else {
            System.out.println("Current information");
            System.out.println("-----------------------------------------------------");
            System.out.printf("Code: %s\n", customer.getCustomerCode());
            System.out.printf("Name : %s\n", customer.getName());
            System.out.printf("Phone : %s\n", customer.getPhone());
            System.out.printf("Email : %s\n", customer.getEmail());

            System.out.println("-----------------------------------------------------");
        }

        String name = Inputter.getName();
        
        String email = Inputter.getEmail(cList);
        
        String phone = Inputter.getNumPhone(cList);
        
        
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        
        Tools.exitAndSaveProgram(); //tool lưu dữ liệu

        System.out.println("The student's information has been successfully updated.");

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
            numberOfTables = Inputter.getInt("Enter number of tables: ", 1, 10000000);
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

        // Hỏi người dùng có muốn tiếp tục đặt hàng không
        String choice;
        do {
            choice = Inputter.getString("Do you want to place another order? (Y/N): ").toUpperCase();
            if (choice.equals("Y")) {
                placeFeastOrder(); // Gọi lại chính nó để tiếp tục đặt hàng
            } else if (!choice.equals("N")) {
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
            }
        } while (!choice.equals("Y") && !choice.equals("N"));
        Tools.exitAndSaveProgram();
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
        System.out.println("========== UPDATE ORDER INFORMATION ==========");
        FeastOrderList orderList = FeastOrderList.readFromFile(); // Đọc danh sách đơn hàng từ file

        // Nhập Order ID
        int orderID = Inputter.getInt("Enter Order ID to update: ", 1, 10000000);
        Order orderToUpdate = null;
        int indexToUpdate = -1;

        // Tìm kiếm đơn hàng trong danh sách
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderID() == orderID) {
                orderToUpdate = orderList.get(i);
                indexToUpdate = i;
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
        System.out.println(orderToUpdate); // 🔹 Chỉ in toàn bộ thông tin một lần

        // Đọc danh sách thực đơn từ file
        FMenuList feastMenu = FMenuList.readFromFile();

        // Lấy giá tiền hiện tại của menu
        Feast currentFeast = feastMenu.getFeastByCode(orderToUpdate.getFeastCode());
        int menuPrice = (currentFeast != null) ? currentFeast.getFeastPrice() : 0;
        int numberOfTables = orderToUpdate.getNumberOfTables(); // Số bàn hiện tại

        // Nhập mã Set Menu mới
        String newMenuCode = Inputter.getString("Enter new Set Menu Code (press Enter to keep current): ")
                .toUpperCase().trim();

        if (!newMenuCode.isEmpty()) {
            Feast newFeast = feastMenu.getFeastByCode(newMenuCode);
            if (newFeast == null) {
                System.out.println("Invalid Set Menu Code! Keeping current menu.");
            } else {
                orderToUpdate.setFeastCode(newMenuCode);
                menuPrice = newFeast.getFeastPrice(); // Cập nhật giá tiền của menu mới
            }
        }

        // Nhập số bàn mới
        String tableInput = Inputter.getString("Enter new number of tables (press Enter to keep current): ").trim();
        if (!tableInput.isEmpty()) {
            try {
                int newTableCount = Integer.parseInt(tableInput);
                if (newTableCount > 0) {
                    numberOfTables = newTableCount;
                    orderToUpdate.setNumberOfTables(newTableCount);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Keeping current table count.");
            }
        }

        // Nhập ngày tổ chức mới
        String dateInput = Inputter.getString("Enter new event date (DD-MM-YYYY) (press Enter to keep current): ").trim();
        if (!dateInput.isEmpty()) {
            try {
                LocalDate newDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if (newDate.isAfter(LocalDate.now())) {
                    orderToUpdate.setEventDate(newDate);
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Keeping current event date.");
            }
        }

        // Cập nhật tổng chi phí
        int totalCost = menuPrice * numberOfTables;
        orderToUpdate.setTotalCost(totalCost);

        // Cập nhật vào danh sách
        orderList.set(indexToUpdate, orderToUpdate);

        // Ghi danh sách mới vào file
        FeastOrderList.writeToFile(orderList);

        // Hiển thị thông tin cập nhật
        System.out.println(" Order updated successfully! Updated information:");
        System.out.println(orderToUpdate); // 🔥 Chỉ in thông tin đơn hàng đã cập nhật

        // Hỏi tiếp tục cập nhật hay không
        String choice;
        do {
            choice = Inputter.getString("Do you want to update another order? (Y/N): ").toUpperCase();
        } while (!choice.equals("Y") && !choice.equals("N"));

        if (choice.equals("Y")) {
            updateOrder();
        } else {
            Tools.exitAndSaveProgram();
        }
    }

}
