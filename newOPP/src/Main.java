public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng Student
        Student student = new Student();
        student.studentId ="12345";
        student.name =("John Doe");
        student.birthyear = "2000";
        student.major =("Computer Science");
        student.setGpa(3.5);
        student.setSdt(123456789);

        // In ra thông tin sinh viên
        System.out.println(student.getAllInfo());

        // Đăng ký môn học và đánh giá sinh viên
        student.registerSubject("CS101");
        student.rateStudent();
    }
}
