package model;

import tool.Inputter;
import manager.Manager;
import tool.Display;
import tool.Tools;

public class FeasPrj28 {

    private static Manager manager = new Manager();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================================");
            System.out.println("      WELCOME TO THE FEAST ORDER MANAGEMENT       ");
            System.out.println("===================================================");
            System.out.println("1. Add a new customer");
            System.out.println("2. Update customer information");
            System.out.println("3. Search by name customers");
            System.out.println("4. Display feast menu");
            System.out.println("5. Place a feast order");
            System.out.println("6. Update an order");
            System.out.println("7. Display all orders");
            System.out.println("8. Exit");
            System.out.println("===================================================");

            // Nhập lựa chọn từ người dùng
            int choice = Inputter.getInt("Choose 1 -> 8: ", 1, 8);

            switch (choice) {
                case 1:
                    manager.addCustomer();
                    break;
                case 2:
                    manager.updateCustomer();
                    break;
                case 3:
                    manager.searchCusByName();
                    break;
                case 4:
                    manager.displayFeastMenu();
                    break;
                case 5:
                    manager.placeFeastOrder();
                    break;
                case 6:
                    manager.updateOrder();
                    break;
                case 7:
                    int subChoice = Inputter.getInt("1. Display Customer List\n2. Display Order List\nChoose: ", 1, 2);
                    if (subChoice == 1) {
                        Display.displayCustomerList();
                    } else {
                        Display.displayOrderList();
                    }
                    break;
                case 8:
                    Tools.exitAndSaveProgram();
                    System.out.println("Exiting program. Thank you!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
