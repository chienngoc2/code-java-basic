
import java.util.Collections;
import java.util.ArrayList;

import java.util.List;

public class main {


       

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
   
        // In danh sách trước khi sắp xếp
        System.out.println("Before sorting:");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        // Sắp xếp theo tên
        Collections.sort(studentList, new NameComparator()); // solution 1
        // studentList.sort(new NameComparator()); // solution 2

        // In danh sách sau khi sắp xếp theo tên
        System.out.println("After sorting by name:");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        // Sắp xếp theo ID
        Collections.sort(studentList, new IDComparator());
        System.out.println("After sorting by ID:");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        // Sắp xếp theo GPA
        Collections.sort(studentList, new GpaComparator());
        System.out.println("After sorting by GPA:");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }
}



