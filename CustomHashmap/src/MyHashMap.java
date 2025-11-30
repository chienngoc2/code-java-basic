import java.util.HashMap;  
import java.util.Map;

public class MyHashMap extends HashMap<String, Student> {  
   // Trả về một chuỗi các số điện thoại của sinh viên có GPA trên 3
     public String getPhoneNumberOfStudentsHaveGPAAbove3() {
        StringBuilder result = new StringBuilder(); // Sử dụng StringBuilder để tối ưu
        for (Map.Entry<String, Student> entry : this.entrySet()) {
            Student student = entry.getValue();
            if (student.getGPA() > 3) {
                result.append(entry.getKey()).append(" ");
            }
        }
        return result.toString().trim(); // Loại bỏ khoảng trắng ở cuối
    }

    //  Cập nhật GPA của sinh viên dựa trên số điện thoại
    public void updateGpaByPhoneNumber(String phoneNumber, double newGpa) {  
        Student student = this.get(phoneNumber);  
        if (student != null) {  
            student.setGPA(newGpa);  
        }  
    }  
}