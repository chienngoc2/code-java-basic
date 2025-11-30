
import java.util.HashMap;
import java.util.Map;

public class MapCollectionsDemo {

    public static void main(String[] args) {
        //create5 students Student student1 = new Student(1, "Doe",3.5);  
        Student student1 = new Student("Smit", 3.0, 5);
        Student student2 = new Student("Smith", 1.0, 2);
        Student student3 = new Student("Johnson", 3.2, 1);
        Student student4 = new Student("Brown", 2.8, 4);
        Student student5 = new Student("Williams", 2.6, 3);
        Map<String, Student> studentMap = new HashMap<>(); // create a hash map  
        studentMap.put("090789001", student1);
        studentMap.put("090789002", student2);
        studentMap.put("090789003", student3);
        studentMap.put("090789004", student4);
        studentMap.put("090789005", student5);

        // print the student with phone 090789003  
        Student student = studentMap.get("090789003"); // get the element with key 090789003  
        System.out.println("info: " + student.toString());
        System.out.println("All students by entrySet: ");
        for (String key : studentMap.keySet()) {//get all keys  
            Student currentStudent = studentMap.get(key);
            System.out.println("key = " + key + " -info: " + currentStudent.toString());
        }

        //print all students by values:  
        System.out.println("All students by values: ");

        //print all students by values  
        System.out.println("All students by values: ");
        for (Student currentStudent : studentMap.values()) { //get all values, approve duplicates  
            System.out.println("info: " + currentStudent.toString());
        }

       //remove a student with key 090789003  
        studentMap.remove("090789003");
        System.out.println("After removing a student with key 090789003: ");
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " - info: " + entry.getValue().toString());
        }

        //check if map contains key  
        if (studentMap.containsKey("090789003")) {
            System.out.println("Student with key 090789003 exists");
        } else {
            System.out.println("Student with key 090789003 does not exist");
        }
        
        //Check size of map
        System.out.println("Size of map: "+studentMap.size());
        
        // demo treeMap
        System.out.println("Demo TreeMap: ");
        Map<String, Student> studentTreeMap = new TreeMap<>();
        studentTreeMap.put("090789004", student4);
        studentTreeMap.put("090789001", student1);
        studentTreeMap.put("090789005", student5);
        studentTreeMap.put("090789003", student3);
        studentTreeMap.put("090789002", student2);
        for (Map.Entry<String, Student> entry : studentTreeMap.entrySet()) {  
        System.out.println("key: " + entry.getKey() + "-info: " + entry.getValue().toString());  
}  
        
    }
}
