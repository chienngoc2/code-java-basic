
package model;

import Tool.Inputter;
import manager.Management;
import data.MountainList;
import Tool.Tools;

/**
 *
 * @author ADMIN
 */
public class Menu {
      
      private static Management management = new Management();
    
    public static void showMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("===================================================");
            System.out.println("Welcome to the Student Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Update student information");
            System.out.println("3. Display all students");
            System.out.println("4. Delete a student");
            System.out.println("5. Search student by name");
            System.out.println("6. Filter students by campus");
            System.out.println("7. Display registration statistics by mountain peak");
            System.out.println("8. Exit");
            System.out.println("===================================================");

            // Nhập lựa chọn
            int choice = Inputter.getInt("Choose 1 -> 9: ", 1, 9);

            // Xử lý theo lựa chọn của người dùng
            switch (choice) {
                case 1:
                    management.addStudent();
                    break;
                case 2:
                    management.updateStudent();  
                    break;
                case 3:
                    management.displayStudent();  
                    break;
                case 4:
                    management.deleteStudent();  
                    break;
                case 5:
                    management.searchStudentByName();  
                    break;
                case 6:
                    management.filterByCampus();  
                    break;
                case 7:
                    management.displayMountainRes(management.getStudentList()); 
                    break;
                
                case 8:
                        Tools.exitAndSaveProgram() ; //tool lưu dữ liệu
                    break;
                case 9:
                    management.searchMountainPlace();
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    
            }
        }
    }
}
