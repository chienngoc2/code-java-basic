
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        //create5 students Student student1 = new Student(1, "Doe",3.5);  
        Student student1 = new Student("Smit", 3.0, 5);
        Student student2 = new Student("Smith", 1.0, 2);
        Student student3 = new Student("Johnson", 3.2, 1);
        Student student4 = new Student("Brown", 2.8, 4);
        Student student5 = new Student("Williams", 2.6, 3);
        //Demo Set Collection }  
        Set<Student> studentSet = new HashSet<>();
        //print all students System.out.println("All students: ");  
        for (Student student : studentSet) {
            System.out.println("info: " + student.toString());
        }

        //get size of set System.out.println("Size of set: " + studentSet.size());  
        //check duplicated student1 studentSet.add(student1);  
        System.out.println("After adding duplicated student1: ");
        for (Student student : studentSet) {
            System.out.println("info: " + student.toString());
        }
        //remove student3 studentSet.remove(student3);  
        System.out.println("After removing student3: ");
        for (Student student : studentSet) {
            System.out.println("info: " + student.toString());
        }

        //check if set contains student2 if (studentSet.contains(student2)) {  
        System.out.println("Student2 exists");

        //demo TreeSet
        Set<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);
        studentTreeSet.add(student4);
        studentTreeSet.add(student5);

        //print all students
        System.out.println("all stu in treeset: ");
        for (Student student : studentTreeSet) {
            System.out.println(student.toString());
        }
        System.out.println("After adding duplicated student1: ");
        for (Student student : studentTreeSet) {
            System.out.println("info: " + student.toString());
        }

         
        Student student6 = new Student(5, "Taylor", 2.6);
        studentTreeSet.add(student6);
        System.out.println("After adding student6: ");
        for (Student student : studentTreeSet) {
            System.out.println("info: " + student.toString());
        }

    }
}
