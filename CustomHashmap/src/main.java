
      import java.util.Map;  

public class main {  
    public static void main(String[] args) {  
        //create 5 students  
        Student student1 = new Student(1, "Doe", 3.5);  
        Student student2 = new Student(2, "Smith", 1.0);  
        Student student3 = new Student(3, "Johnson", 3.2);  
        Student student4 = new Student(4, "Brown", 2.8);  
        Student student5 = new Student(5, "Williams", 2.6);  

        MyHashMap studentMap = new MyHashMap(); // create a hash map  
        studentMap.put("090789001", student1); //add student1 to the map with key 090789001  
        studentMap.put("090789002", student2);  
        studentMap.put("090789003", student3);  
        studentMap.put("090789004", student4);  
        studentMap.put("090789005", student5);  

        System.out.println("phone number of students have GPA above 3:");  
        String phoneResult = studentMap.getPhoneNumberOfStudentsHaveGPAAbove3();  
        System.out.println(phoneResult);  

        System.out.println("update gpa of student by phone number:");  
        studentMap.updateGpaByPhoneNumber("090789004", 4.0);  

        //print all students by entrySet  
        System.out.println("All students by entrySet after update:");  
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) { //get all  
            System.out.println("key: " + entry.getKey() + " - info: " + entry.getValue());  
        }  
    }  
}
    