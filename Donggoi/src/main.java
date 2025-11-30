public class main {
    public static void main(String[] args) {
        // Tạo một đối tượng Student
        NewClass student = new NewClass();
        student.setStudentId("12345");
        student.setName("John Doe");
        student.setBirthYear("2000");
        student.setMajor("Computer Science");
        student.setGpa(3.5);
        student.setSdt(123456789);

        // In ra thông tin sinh viên
        System.out.println(student.getAllInfo());

        // Đăng ký môn học và đánh giá sinh viên
        student.registerSubject("CS101");
        student.rateStudent();
    }
}
