
package customtreeset;
  import java.util.Set;  

import java.util.TreeSet;
public class CustomTreeSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      

 
   
        // create 5 students  
    
        MyTreeSet students = new MyTreeSet();

        // Thêm sinh viên vào danh sách
        students.add(new Student(1, "Alice", 3.5));
        students.add(new Student(2, "Bob", 2.8));
        students.add(new Student(3, "Charlie", 3.2));

        // Tìm sinh viên có GPA trên 3
        Set<Student> highGPAStudents = students.getStudentsHaveGPAAbove3();
        System.out.println("Sinh viên có GPA trên 3: " + highGPAStudents);

        // Tìm sinh viên theo ID
        Student student = students.findStudentById(2);
        System.out.println("Tìm sinh viên với ID 2: " + student);
    }
}

   
