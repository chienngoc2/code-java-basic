package colectiondemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ColectionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student studentOne = new Student(1, "JOhn", 3.5);
        Student studentTwo = new Student(2, "Jne", 3.0);
        Student studentThree = new Student(3, "Dau", 3.2);
        Student studentFour = new Student(4, "Smit", 3.9);
        Student studentFive = new Student(5, "JOhn2", 3.7);
        // creat an ArayList
        List<Student> studentList = new ArrayList<>();
        // addStudent to list
        studentList.add(studentOne);
        studentList.add(studentTwo);
        studentList.add(studentThree);
        studentList.add(studentFour);
        studentList.add(studentFive);
        //print the list of student

        int sizeOfList = studentList.size(); //get the size of the list
        for (int i = 0; i < sizeOfList; i++) {
            Student student = studentList.get(i); //get the student at index i
            System.out.println(student.toString());
        }

        // insert a student at index 1  
        Student studentSix = new Student(6, "Hen", 3.5);
        studentList.add(1, studentSix);

        System.out.println("After inserting a student at index 1");
        sizeOfList = studentList.size();//get the size of the list  
        for (int i = 0; i < sizeOfList; i++) {
            Student student = studentList.get(i);//get the student at index i  
            System.out.println(student.toString());
        }
        // remove a student at index 1  
        studentList.remove(1);//remove the student at index 1  
        System.out.println("After removing a student at index 1");
        sizeOfList = studentList.size();//get the size of the list  
        for (int i = 0; i < sizeOfList; i++) {
            Student student = studentList.get(i);//get the student at index i  
            System.out.println(student.toString());
        }
        //check if the list contains a student six
        System.out.println("");
        System.out.println("check the list if it contains student 6");
        if (studentList.contains(studentSix)) {
            System.out.println("Student six is in the list");
        } else {
            System.out.println("Student six is not in the list");
        }
        //add all students to a new list  
        List<Student> newStudentList = new ArrayList<>();
        newStudentList.addAll(studentList); //add all students to newStudentList  
        //print the new list  
        System.out.println("New List of students: ");
        for (int i = 0; i < newStudentList.size(); i++) {
            Student student = newStudentList.get(i);
            System.out.println(student.toString());
        }
        //clear the list
        studentList.clear();

        //check if the list is empty
        if (studentList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list is not empty");
        }
        // convert the list to an array  
        int length = newStudentList.size();
        Student[] studentArray = new Student[length];
        newStudentList.toArray(studentArray);

        //print the array  
        System.out.println("Array of students: ");
        for (int i = 0; i < studentArray.length; i++) {
            Student student = studentArray[i];
            System.out.println(student.toString());
        }
        // print list by iterator  
        Iterator<Student> iterator = newStudentList.iterator();
        System.out.println("List of students by iterator: ");
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.toString());
        }
        //demo Vector  
        List<Student> studentVector = new Vector<>();
        studentVector.add(studentOne);
        studentVector.add(studentTwo);
        studentVector.add(studentThree);
        studentVector.add(studentFour);
        studentVector.add(studentFive);

        //print the vector  
        System.out.println("Vector of students: ");
        for (int i = 0; i < studentVector.size(); i++) {
            Student student = studentVector.get(i);
            System.out.println(student.toString());
        }

        // set student at index 0  
        Student studentSeven = new Student(7, "Tom", 3.5);
        studentList.set(0, studentSeven);//set studentSeven at index 0  
        System.out.println("After setting a student at index 0");
        //get the size of the list  
        sizeOfList = studentList.size();
        for (int i = 0; i < sizeOfList; i++) {
            Student student = studentList.get(i);//get the student at index i  
            System.out.println(student.toString());
        }
        // compare two students 1 & 2  
        int compareResult = studentOne.compareTo(studentTwo);
        System.out.println("result=" + compareResult);
        if (compareResult > 0) {
            System.out.println("Student one is greater than student two");
        } else if (compareResult < 0) {
            System.out.println("Student one is less than student two");
        } else {
            System.out.println("Student one is the same to student two");
        }
        //sort the list  
        Collections.sort(newStudentList);//solution 1  

        //print the sorted list  
        System.out.println("Sorted vector of students: ");
        for (int i = 0; i < newStudentList.size(); i++) {
            Student student = newStudentList.get(i);
            System.out.println(student.toString());
        }
    }

}
