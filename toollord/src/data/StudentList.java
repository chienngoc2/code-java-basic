
package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import manager.Student;

/**
 *
 * @author ADMIN
 */

    public class StudentList extends ArrayList<Student> {
    private static final String filePath = "src/data/students.dat"; 

    public static void writeToFile(StudentList studentList) {
        // Ghi danh sách sinh viên vào file students.dat
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList); // Ghi đối tượng danh sách sinh viên vào file
            oos.close();
            fos.close();
            System.out.println("Data successfully saved to file.");
        } catch (IOException e) {
            System.err.println("Error while saving data to file.");
            e.printStackTrace();
        }
    }

    public static StudentList readFromFile() {
        
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            StudentList studentList = (StudentList) ois.readObject(); // Đọc đối tượng danh sách sinh viên từ file
            ois.close();
            fis.close();
            System.out.println("Data successfully loaded from file.");
            return studentList;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while reading data from file.");
            e.printStackTrace();
        }
        return new StudentList(); // Trả về danh sách rỗng nếu xảy ra lỗi
    }
}


