/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import data.MountainList;
import Tool.Acceptable;
import Tool.Inputter;
import Tool.Tools;
import data.StudentList;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Management {

    private MountainList mL;
    private Scanner sc = new Scanner(System.in);
    public  static List<Student> sList;

    public Management(MountainList mL) {
        this.mL = mL;
        // Đọc dữ liệu từ file nhị phân vào danh sách sList
        
        this.sList = new ArrayList<>(); // Chuyển từ StudentList sang ArrayList

    }

    public static List<Student> getStudentList() { //phương thức để truy list Student
        return sList;
    }

    public String getCampusPrefix() {
        System.out.println("Choose campus 1 -> 5 (SE|HE|QE|DE|CE): ");
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice < 1 || choice > 5) {
            System.out.println("Please enter a valid choice 1 -> 5: ");
            choice = sc.nextInt();
            sc.nextLine();
        }

        switch (choice) {
            case 1:
                return "SE";

            case 2:
                return "HE";
            case 3:
                return "QE";
            case 4:
                return "DE";
            case 5:
                return "CE";
            default:
                return "Invalid choice";
        }

    }
    //tạo ds dki sau khi đã biết mountainList

    public void addStudent() {
        MountainList mountainList = MountainList.readFromFile("D:/temp_3/LAB211/MountainList.csv");
        if (mountainList.isEmpty()) {
            System.out.println("The mountain list is empty or the file cannot be read! Unable to add students.");
            return;
        }
        String campus = getCampusPrefix();
        String id = Inputter.getID(campus);
        String name = Inputter.getName();
        String email = Inputter.getEmail();
        String phone = Inputter.getNumPhone();

        // Lựa chọn núi
        System.out.println("Choose a mountain:");
        Object mountainChoice = Inputter.objMenu(mountainList.toArray());

        if (!(mountainChoice instanceof Mountain)) {
            System.out.println("Invalid selection!");
            return;
        }

        int mountainCode = ((Mountain) mountainChoice).getMountainCode();

        double tuition = Inputter.getTuitionCal(phone);
        

        Student infoReg = new Student(id, name, phone, email, mountainCode, tuition);
        System.out.println(infoReg.toString());
        sList.add(infoReg);
        
        
        boolean hasUnsavedChanges = true;
        Tools.exitProgram(hasUnsavedChanges); //tool lưu dữ liệu

        System.out.println("New registration has been added successfully!");
    }

    public void updateStudent() {
        StudentList loadedList = StudentList.readFromFile();   // Đọc dữ liệu từ file nhị phân để đảm bảo danh sách sList mới nhất
        sList = new ArrayList<>(loadedList);

        System.out.println("Enter ID code: ");
        String idCode = sc.nextLine();
        while (!Acceptable.isValid(idCode, Acceptable.STU_ID_VALID)) { // nếu sai cú pháp nhập lại
            System.out.println("Please enter a valid student ID.");
            idCode = sc.nextLine();
        }
        Student student = Inputter.getStudent(idCode, sList); // tìm sinh viên dựa trên id
        if (student == null) {
            System.out.println("This student has not registered yet. Please try again.");
        } else {
            System.out.println("Current information");
            System.out.println("-----------------------------------------------------");
            System.out.printf("Student ID: %s\n", student.getId());
            System.out.printf("Name : %s\n", student.getName());
            System.out.printf("Phone : %s\n", student.getPhone());
            System.out.printf("Email : %s\n", student.getEmail());
            System.out.printf("Mountain : %s\n", student.getMountainCode());
            System.out.printf("Fee : %.2f\n", student.getTuitionFee());
            System.out.println("-----------------------------------------------------");
        }

        String name = Inputter.getName();
        student.setName(name);
        String email = Inputter.getEmail();
        student.setEmail(email);
        String phone = Inputter.getNumPhone();
        student.setPhone(phone);

        int mountainCode = Inputter.getInt("Enter mountain peak code:", 1, 13);
        student.setMountainCode(mountainCode);

        boolean hasUnsavedChanges = true;
        Tools.exitProgram(hasUnsavedChanges); //tool lưu dữ liệu

        System.out.println("The student's information has been successfully updated.");

    }

    public void displayStudent() {

        StudentList loadedList = StudentList.readFromFile();
        sList = new ArrayList<>(loadedList);

        if (sList.isEmpty()) {
            System.out.println("No student has registered yet.");
            return;
        }

        System.out.println("Registered Students:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-15s | %-10s | %-12s%n",
                "Student ID", "Name", "Phone", "Peak Code", "Fee");
        System.out.println("---------------------------------------------------------------------------------");

        for (Student student : sList) {
            System.out.printf("%-12s | %-20s | %-15s | %-10d | %-12.2f%n",
                    student.getId(),
                    student.getName(),
                    student.getPhone(),
                    student.getMountainCode(),
                    student.getTuitionFee());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void deleteStudent() {

        StudentList loadedList = StudentList.readFromFile();
        sList = new ArrayList<>(loadedList);

        System.out.println("Enter ID code: ");
        String idCode = sc.nextLine().trim();
        while (!Acceptable.isValid(idCode, Acceptable.STU_ID_VALID)) { // nếu sai cú pháp nhập lại
            idCode = Inputter.getString("Please enter id again");
        }
        Student student = Inputter.getStudent(idCode, sList); // tìm sinh viên dựa trên id
        if (student == null) {
            System.out.println("This student has not registered yet. Please try again.");
        } else {
            System.out.println("Student Details:");
            System.out.println("------------------------------------------------");
            System.out.printf("Student ID: %s\n", student.getId());
            System.out.printf("Name : %s\n", student.getName());
            System.out.printf("Phone : %s\n", student.getPhone());
            System.out.printf("Email : %s\n", student.getEmail());
            System.out.printf("Mountain : %s\n", student.getMountainCode());
            System.out.printf("Fee : %.2f\n", student.getTuitionFee());
            System.out.println("------------------------------------------------");
        }

        String confirm = Inputter.getString("Are you sure you want to delete this registration? (Y/N): ");
        if (confirm.equalsIgnoreCase("Y")) {
            // Xóa sinh viên nếu người dùng xác nhận
            sList.remove(student);
            boolean hasUnsavedChanges = true;
            Tools.exitProgram(hasUnsavedChanges);
            System.out.println("The registration has been successfully deleted.");
        } else {
            // Quay lại menu chính nếu người dùng không xác nhận
            System.out.println("Operation cancelled. Returning to the main menu.");
        }
    }

    public void searchStudentByName() {

        StudentList loadedList = StudentList.readFromFile();
        sList = new ArrayList<>(loadedList);
        String searchName = Inputter.getName().toLowerCase().trim(); // dùng static để nhập & ktra cú pháp name
        List<Student> matchingStudents = new ArrayList<>();
        for (Student s : sList) {
            if (s.getName().toLowerCase().contains(searchName)) {
                matchingStudents.add(s);
            }
        }
        if (matchingStudents.isEmpty()) {
            System.out.println("No one matches the search criteria!");

        } else {

            // Hiển thị danh sách sinh viên phù hợp
            System.out.println("Matching Students:");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-12s | %-20s | %-15s | %-12s | %-15s%n",
                    "Student ID", "Name", "Phone", "Peak Code", "Fee");
            System.out.println("-------------------------------------------------------------------------------");

            // In ra thông tin của mỗi sinh viên trong danh sách matchingStudents
            for (Student student : matchingStudents) {
                System.out.printf("%-12s | %-20s | %-15s | %-12s | %-15.2f%n",
                        student.getId(), student.getName(), student.getPhone(),
                        student.getMountainCode(), student.getTuitionFee());
            }
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public void filterByCampus() {
        StudentList loadedList = StudentList.readFromFile();
        sList = new ArrayList<>(loadedList);
        System.out.println("Enter Campus Code(CE, DE, SE, HE, QE): ");
        String campus = sc.nextLine().toUpperCase().trim();

        if (campus != "CE" || campus != "HE" || campus != "SE" || campus != "QE" || campus != "SDE") {
            System.out.println("Invalid campus code! Please enter one of the following: CE, DE, HE, SE, QE.");
        }

        List<Student> filteredStudents = new ArrayList<>();
        for (Student s : sList) {
            if (s.getId().startsWith(campus)) {
                filteredStudents.add(s);
            }
        }
        if (filteredStudents.isEmpty()) {
            System.out.printf("No students have registered under the campus: %s%n", campus);

        } else {

            // Hiển thị danh sách sinh viên phù hợp
            System.out.printf("Registered Students Under Campus (%s):%n", campus);
            System.out.println("--------------------------------------------------------------");
            System.out.printf("%-12s | %-20s | %-15s | %-12s | %-15s%n",
                    "Student ID", "Name", "Phone", "Peak Code", "Fee");
            System.out.println("--------------------------------------------------------------");

            // In ra thông tin của mỗi sinh viên trong danh sách matchingStudents
            for (Student student : filteredStudents) {
                System.out.printf("%-12s | %-20s | %-15s | %-12s | %-15.2f%n",
                        student.getId(), student.getName(), student.getPhone(),
                        student.getMountainCode(), student.getTuitionFee());
            }
            System.out.println("---------------------------------------------------------------");
        }

    }

    public void displayMountainRes(List<Student> sList) {
        StudentList loadedList = StudentList.readFromFile(); // đọc dữ liệu mới nhất từ file
        sList = new ArrayList<>(loadedList);

        Map<String, Integer> participantCount = new HashMap<>(); //map lưu tên peak và đếm sv
        Map<String, Double> totalTuitionFee = new HashMap<>();  // map lưu tên peak và tiền

        for (Student s : sList) {
            String peak = "MT" + String.format("%02d", s.getMountainCode());
            double fee = s.getTuitionFee();

            // Cập nhập giá trị  count và fee
            participantCount.put(peak, participantCount.getOrDefault(peak, 0) + 1);
            totalTuitionFee.put(peak, totalTuitionFee.getOrDefault(peak, 0.0) + fee);

        }

        // Hiển thị kết quả
        System.out.println("Statistics of Registration by Mountain Peak:");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-15s | %-22s | %-15s%n", "Peak Name", "Number of Participants", "Total Cost");
        System.out.println("-------------------------------------------------------------------------------------------");

        if (participantCount.isEmpty()) {
            System.out.println("No registration data available for any mountain peaks.");
        } else {
            for (String peak : participantCount.keySet()) {
                int count = participantCount.get(peak);
                double totalFee = totalTuitionFee.get(peak);
                System.out.printf("%-15s | %-22d | %-15.2f%n", peak, count, totalFee);
            }
        }

        System.out.println("----------------------------------------------------------------------------");

    }

   
}
