/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class NewClass {
      String studentId;
    String name;
    String birthyear;  // Giữ kiểu String hoặc đổi thành int nếu muốn
    String major;
    int sdt;
    double gpa;

    public NewClass(String studentId) {
        this.studentId = studentId;
    }

    NewClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    // Getter và Setter cho studentId
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Getter và Setter cho name
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Setter cho birthyear
    public void setBirthYear(String birthYear) {  // Sửa lại thành String nếu giữ birthyear là String
        this.birthyear = birthYear;
    }

    public String getBirthYear() {
        return birthyear;
    }

    // Getter và Setter cho major
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Getter và Setter cho sdt
    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    // Getter và Setter cho gpa
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Đăng ký môn học
    void registerSubject(String subjectCode) {
        System.out.println("Register subject: " + subjectCode);
    }

    // Đăng ký lớp học
    boolean registerClass(String classCode) {
        if (classCode.equals("PRO192")) {
            return true;
        } else {
            return false;
        }
    }

    // Đánh giá sinh viên
    void rateStudent() {
        if (gpa >= 3) {
            System.out.println("Good Student");
        } else {
            System.out.println("Bad Student");
        }
    }

    // Thanh toán học phí
    boolean payTuition(double amount) {
        if (amount >= 1000) {
            return true;
        } else {
            return false;
        }
    }

    // Lấy thông tin sinh viên
    String getAllInfo() {
        String info = "ID: " + studentId + "\n" +
                      "Name: " + name + "\n" +
                      "Birth year: " + birthyear + "\n" +
                      "Major: " + major;
        return info;  // Trả về thông tin
    }
}


