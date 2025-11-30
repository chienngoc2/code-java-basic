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
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Management {

    private Scanner sc = new Scanner(System.in);
    public static List<Student> sList = new ArrayList<>();

    public static List<Student> getStudentList() { //phương thức để truy list Student(dùng để lưu)
        return sList;
    }

    public String getCampusPrefix() {
        System.out.println("Choose campus 1 -> 5 (SE|HE|QE|DE|CE): ");
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                if (choice >= 1 && choice <= 5) {
                    break;
                } else {
                    System.out.println("Valid choice (1->5)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.Please enter a number (1->5)");
            }
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
                return "/n";
        }

    }
    //tạo ds dki sau khi đã biết mountainList

    public void addStudent() {

        String campus = getCampusPrefix();
        String id = Inputter.getID(campus);
        String name = Inputter.getName();
        String email = Inputter.getEmail(sList);
        String phone = Inputter.getNumPhone(sList);

        MountainList mountainList = MountainList.readFromFile();
        if (mountainList.isEmpty()) {
            System.out.println("The mountain list is empty or the file cannot be read! Unable to add students.");
            return;
        }
        System.out.println("Choose mountain:");
        Object mountainChoose = Inputter.objMenu(mountainList.toArray()); // chọn 1 núi trong danh sách

        // lấy sdt từ file
        int mountainCode = ((Mountain) mountainChoose).getMountainCode();
        Mountain selectedMountain = mountainList.getMountainByCode(mountainCode); // Tìm núi có code = 5

        double tuition = selectedMountain.getPrice();
        double tuitionSale = Inputter.getSaletionCal(phone, tuition);
        Student infoReg = new Student(id, name, phone, email, mountainCode, tuitionSale);
        System.out.println(infoReg.toString());
        sList.add(infoReg);

        Tools.exitAndSaveProgram(); //tool lưu và thoát

        System.out.println("New registration has been added successfully!");
    }

    public void updateStudent() {
        sList = StudentList.readFromFile(); // cập nhập giá trị mới nhất từ file

        System.out.println("Enter ID code: ");
        String idCode = sc.nextLine().toUpperCase().trim();
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
        String email = Inputter.getEmail(sList);
        student.setEmail(email);
        String phone = Inputter.getNumPhone(sList);
        student.setPhone(phone);

        int mountainCode = Inputter.getInt("Enter mountain peak code:", 1, 13);
        student.setMountainCode(mountainCode);

        Tools.exitAndSaveProgram(); //tool lưu dữ liệu

        System.out.println("The student's information has been successfully updated.");

    }

    public void displayStudent() {

        sList = StudentList.readFromFile();
        MountainList ml = MountainList.readFromFile();
        if (sList.isEmpty()) {
            System.out.println("No student has registered yet.");
            return;
        }
        //sList.sort(Comparator.comparingDouble(Student::getTuitionFee));
        //sList.sort((s1, s2) -> Double.compare(s1.getTuitionFee(), s2.getTuitionFee())); // cao đến thấp đảo ngược thứ tự s1, s2 fee

        sList.sort((s1, s2) -> {
            Mountain mt1 = ml.getMountainByCode(s1.getMountainCode());
            Mountain mt2 = ml.getMountainByCode(s2.getMountainCode());
            return mt1.getMountain().compareTo(mt2.getMountain());
        });

        System.out.println("Registered Students:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-15s| %-15s | %-10s | %-12s%n",
                "Student ID", "Name", "MT Name", "Phone", "Peak Code", "Fee");
        System.out.println("---------------------------------------------------------------------------------");

        for (Student student : sList) {
            Mountain mt = ml.getMountainByCode(student.getMountainCode());
            String name = mt.getMountain();
            System.out.printf("%-12s | %-20s |%-15s| %-15s | %-10d | %-12.2f%n",
                    student.getId(),
                    student.getName(),
                    name,
                    student.getPhone(),
                    student.getMountainCode(),
                    student.getTuitionFee());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void deleteStudent() {

        sList = StudentList.readFromFile();

        System.out.println("Enter ID code: ");
        String idCode = sc.nextLine().toUpperCase().trim();
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

            Tools.exitAndSaveProgram();
            System.out.println("The registration has been successfully deleted.");
        } else {
            // Quay lại menu chính nếu người dùng không xác nhận
            System.out.println("Operation cancelled. Returning to the main menu.");
        }
    }

    public void searchStudentByName() {

        sList = StudentList.readFromFile();
        MountainList ml = MountainList.readFromFile();
        String searchName = Inputter.getName().toLowerCase().trim(); // dùng static để nhập & ktra cú pháp name
        List<Student> matchingStudents = new ArrayList<>();  // tạo list mới để chứa student có tên cần tìm
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
            System.out.printf("%-12s | %-20s | %-15s | %-15s| %-12s | %-15s%n",
                    "Student ID", "Name", "MT NAME", "Phone", "Peak Code", "Fee");
            System.out.println("-------------------------------------------------------------------------------");

            // In ra thông tin của mỗi sinh viên trong danh sách matchingStudents
            for (Student student : matchingStudents) {
                Mountain mt = ml.getMountainByCode(student.getMountainCode());
                String name = mt.getMountain();
                System.out.printf("%-12s | %-20s | %-15s | %-15s | %-12s | %-15.2f%n",
                        student.getId(), student.getName(), name, student.getPhone(),
                        student.getMountainCode(), student.getTuitionFee());
            }
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public void searchMountainPlace() {
        sList = StudentList.readFromFile();
        MountainList ml = MountainList.readFromFile();
        String searchName = Inputter.getName().toLowerCase().trim();
        List<Mountain> matchingPlace = new ArrayList<>();
        for (Mountain mt : ml) {

            if (mt.getProvince().toLowerCase().contains(searchName)) {
                matchingPlace.add(mt);
            }
        }
        if (matchingPlace.isEmpty()) {
            System.out.println("Can't find!");
        } else {
            System.out.println("Mountain:");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-12s | %-20s | %-15s | %-15s| %-15s%n",
                    "MT code", "MT name", "MT place", "MT des", "MT price");
            System.out.println("-------------------------------------------------------------------------------");

            // In ra thông tin của mỗi sinh viên trong danh sách matchingStudents
            for (Mountain mt : matchingPlace) {
               
                System.out.printf("%-12s | %-20s | %-15s | %-15s | %-15.2f%n",
                        String.format("MT%02d", mt.getMountainCode()), mt.getMountain(), mt.getProvince(), mt.getDescription(),
                         mt.getPrice());
            }
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public void displayMountainRes(List<Student> sList) {
        sList = StudentList.readFromFile();
        MountainList ml = MountainList.readFromFile();

        Map<String, Integer> participantCount = new HashMap<>();
        Map<String, Double> totalTuitionFee = new HashMap<>();
        Map<String, String> mountainName = new HashMap<>();

        //sList.sort((s1, s2) -> Integer.compare(s1.getMountainCode(),s2.getMountainCode())); // sort peak code
        for (Student s : sList) {
            String peak = "MT" + String.format("%02d", s.getMountainCode());
            double fee = s.getTuitionFee();
            Mountain mt = ml.getMountainByCode(s.getMountainCode());
            String mtName = mt.getMountain();
            participantCount.put(peak, participantCount.getOrDefault(peak, 0) + 1);
            totalTuitionFee.put(peak, totalTuitionFee.getOrDefault(peak, 0.0) + fee);
            mountainName.put(peak, mtName);
        }
        // List<String> sortCount = new ArrayList<>(participantCount.keySet());
        //sortCount.sort((p1, p2) -> Integer.compare(participantCount.get(p2), participantCount.get(p1))); // Giảm dần sắp xếp theo số học sinh tham gia

        List<String> sortFee = new ArrayList<>(totalTuitionFee.keySet());
        sortFee.sort((f1, f2) -> {
            Double fee1 = totalTuitionFee.getOrDefault(f1, 0.0);
            Double fee2 = totalTuitionFee.getOrDefault(f2, 0.0);
            return Double.compare(fee2, fee1);
        });

        // Hiển thị kết quả
        System.out.println("Statistics of Registration by Mountain Peak:");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-15s |%-15s| %-22s | %-15s%n", "Peak Name", "MT Name", "Number of Participants", "Total Cost");
        System.out.println("-------------------------------------------------------------------------------------------");

        if (participantCount.isEmpty()) {
            System.out.println("No registration data available for any mountain peaks.");
        } else {
            for (String peak : participantCount.keySet()) {
                int count = participantCount.get(peak);
                double totalFee = totalTuitionFee.get(peak);
                String mtName = mountainName.get(peak);
                System.out.printf("%-15s |%-15s| %-22d | %-15.2f%n", peak, mtName, count, totalFee);
            }
        }

        System.out.println("----------------------------------------------------------------------------");

    }
    public void filterByCampus() {
        sList = StudentList.readFromFile();
        
        System.out.println("Enter Campus Code(CE, DE, SE, HE, QE): ");
        String campus = sc.nextLine().toUpperCase().trim();

        if (campus != "CE" || campus != "HE" || campus != "SE" || campus != "QE" || campus != "DE") {
            System.out.println("Invalid campus code! Please enter one of the following: CE, DE, HE, SE, QE.");
        }

        List<Student> filteredStudents = new ArrayList<>(); // tạo list mới chứa thông tin theo danh sách campus
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
            System.out.println("--------------------------------------------------------------=-------------------");
            System.out.printf("%-12s | %-15s | %-15s | %-12s | %-15s%n",
                    "Student ID", "Name", "Phone", "Muontain Code", "Fee");
            System.out.println("----------------------------------------------------------------------------------");

            // In ra thông tin của mỗi sinh viên trong danh sách matchingStudents
            for (Student student : filteredStudents) {
                System.out.printf("%-12s | %-15s | %-15s | %-12s | %-,15.2f%n",
                        student.getId(), student.getName(), student.getPhone(),
                        String.format("MT"+"%02d", student.getMountainCode()), student.getTuitionFee());
            }
            System.out.println("----------------------------------------------------------------------------------");
        }

    }

}
