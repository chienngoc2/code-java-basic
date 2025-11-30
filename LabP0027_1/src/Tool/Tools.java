/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import data.StudentList;
import java.util.List;
import java.util.Scanner;
import manager.Management;
import manager.Student;

/**
 *
 * @author ADMIN
 */
public class Tools {
    
    private static Scanner sc = new Scanner(System.in);  // Đảm bảo rằng Scanner được khai báo ở đây hoặc truyền vào

    public static void exitProgram(boolean hasUnsavedChanges) { 
    if (hasUnsavedChanges) {  // Kiểm tra nếu có thay đổi chưa lưu
        System.out.println("You have unsaved changes. Do you want to save the changes? (Y/N)");
        String choice = sc.nextLine().trim().toUpperCase();

        if (choice.equals("Y")) {
             List<Student> sList = Management.getStudentList();
                StudentList studentList = new StudentList();
                studentList.addAll(sList); // Thêm toàn bộ danh sách vào StudentList
            StudentList.writeToFile(studentList); // Ghi danh sách vào file
            System.out.println("Changes have been saved.");
        } else if (choice.equals("N")) {
            System.out.println("Changes were not saved.");
        } else {
            System.out.println("Invalid choice. Returning to the main menu...");
            return; // Quay lại menu chính
        }
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

