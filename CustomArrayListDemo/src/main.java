


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class main {

    /**
     * @param args the command line arguments
     */
  
        

    public static void main(String[] args) {
//create 5 students  
        Student student1 = new Student("Doe", 3.5,5);
        Student student2 = new Student("Johnson", 3.2,4);
        Student student3 = new Student("Brown", 4.0,3);
        Student student4 = new Student("Smith", 2.8,2);
        Student student5 = new Student("Williams", 2.6,1);

//create a List of students  
        MyArrayList students = new MyArrayList();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

//find the student with the highest GPA  
        Student highestGPAStudent = students.findHighestGPAStudent();
        if (highestGPAStudent != null) {
            System.out.println("Student with the highest GPA: " + highestGPAStudent.toString());
        }

//calculate the average GPA of all students  
        String averageGPA = students.calculateAverageGPA();
        System.out.println("Average GPA of all students: " + averageGPA);

//sort students by GPA in descending order  
        students.sortStudentsByGPA();
        System.out.println("Students sorted by GPA: ");
        for (Student student : students) {
            System.out.println(student.toString());
        }

//sort students by GPA in descending order  
        students.sortStudentsByGPADescending();
        System.out.println("Students sorted by GPA in decreasing order: ");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

}
