
public class Main {

    public static void main(String[] args) {
        // Các ID mẫu để kiểm tra
        String[] testIds = {
            "se1234", // hợp lệ
            "he56789", // hợp lệ
            "qe12345", // hợp lệ
            "se123", // không hợp lệ (phần số có ít hơn 4 ký tự)
            "qe1234567", // không hợp lệ (phần số nhiều hơn 6 ký tự)
            "de1234", // không hợp lệ (không phải "se", "he" hoặc "qe")
            "he1234a", // không hợp lệ (chứa ký tự không phải số)
        };

        // Kiểm tra từng ID
        for (String id : testIds) {
            System.out.println("ID: " + id + " -> isValid: " + Student.matchId(id));
        }
        String[] testStrings = {
            "hello world!", // Chuỗi với khoảng trắng và dấu câu
            "THIS is A TEST", // Chuỗi viết hoa và viết thường
            "formatCamel Test 123", // Chuỗi có số và chữ thường
            "java_programming_101", // Chuỗi có ký tự đặc biệt
            "sampleText_withVariousWords", // Chuỗi lẫn chữ hoa, thường và ký tự gạch dưới
        };

        // Kiểm tra từng chuỗi
        for (String str : testStrings) {
            String formattedStr = formatCamel(str);
            System.out.println("Input: " + str);
            System.out.println("Formatted (CamelCase): " + formattedStr);
            System.out.println("----");
        }
        

       
}
     static String formatCamel(String str) {
        String result = str.replaceAll("[^a-zA-Z]", "");
        return result;
    }}


