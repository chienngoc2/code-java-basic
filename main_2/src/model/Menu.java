
package model;

import Tool.Inputter;
import manager.Management;
import data.MountainList;
import Tool.Tools;
import java.util.Scanner;

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
            System.out.println("8. Save and Exit");
            System.out.println("===================================================");

            // Nhập lựa chọn
            System.out.println("Choose  [1 -> 8]:  ");
            Scanner sc = new Scanner(System.in);
            
            int choice = 0;
        while(true){
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                
                if(choice >= 1 && choice <= 8){
                    break;
                }
                else
                    System.out.println("Valid choice (1->8)");
            } catch( NumberFormatException e){
                System.out.println("Invalid input.Please enter a number (1->8)");
            }
        }
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
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    
            }
        }
    }
}
