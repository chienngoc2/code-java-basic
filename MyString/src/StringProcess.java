
import java.math.BigDecimal;

public class StringProcess {

    // hàm viết hoa
    public String toUpperCaseString(String input) {
        return input.toUpperCase();
    }

    // hàm viết thường chuỗi
    public String toLowerCaseString(String input) {
        return input.toLowerCase();
    }

    // viết hoa chữ cái đầu
    public String toUpperTheFirstCharacter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    // So sánh 2 hàm có bằng nhau không
    public boolean checkTwoStringIsEqual(String input1, String input2) {
        return input1.equals(input2);
    }

    // So sánh 2 hàm bỏ qua chữ hoa
    public boolean checkTwoStringIsEqualIgnoreCase(String input1, String input2) {
        return input1.equalsIgnoreCase(input2);
    }

    // kiểm tra chuỗi 1 cò chứa chuỗi 2 hay không
    public boolean checkContains(String input1, String input2) {
        return input1.contains(input2);
    }

    //kiểm tra chuỗi 1 có bắt đầu bằng chuỗi 2 không
    public boolean checkStartWith(String input1, String input2) {
        return input1.startsWith(input2);
    }

    //kiểm tra chuỗi 1 có kết thúc bằng chuỗi 2 không
    public boolean checkEndWith(String input1, String input2) {
        return input1.endsWith(input2);
    }

    // hàm thay thế chuỗi cũ bằng chuổi mới
    public String relaceString(String input, String oldString, String newString) {
        return input.replace(oldString, newString);
    }

    // hàm xóa khoảng trắng hai đầu
    public String removeSpaceAtBeginAndEnd(String input) {
        return input.trim();
    }
    // lấy 2 số sau dấu , và làm tròn

    public String formatANumberWithTwoDecimalPlaces(double number) { // solution 1  
        return String.format("%.2f", number); // round  
    }

    // lấy 2 số sau dấu , ko làm tròn nhưng cân import thư viện bigdecimal
    public String formatANumberWithTwoDecimalNotRound(double number) { // solution 3  
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, BigDecimal.ROUND_FLOOR);
        return bd.toString();
    }

    // hàm lấy kí tự từ số đầu vào index
    public char getACharacterAtIndex(String input, int index) { // usage
        return input.charAt(index);
    }

    // đếm kí tự số
    public int countDigitInAString(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) { // input.length() is the number of characters in the string
            if (Character.isDigit(input.charAt(i))) { // Character.isDigit() is a method to check if a character is a digit
                count++;
            }
        }
        return count;
    }

    // đếm kí tự chữ cái
    public int countLetterInAString(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) { // Character.isLetter() is a method to check if a character is a letter
                count++;
            }
        }
        return count;
    }

    // đếm kí tự đặc biệt
    public int countSpecialCharacterInAString(String input) { // no usages
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) { // Character.isLetterOrDigit() is a method to check if a character is a letter or a digit
                count++;
            }
        }
        return count;
    }

    // hàm nghịch đảo
    public String reverseString(String input) { // 1 usage
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    // viết hoa từng chữ cái đầu tiên của từ
    public String upperCaseFirstLetterOfEachWord(String input) { // no usages
        String[] words = input.split(" "); // split the input string into words
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            words[i] = word.substring(0, 1).toUpperCase() + word.substring(1);
        }
        return String.join(" ", words); // join the words with a space
    }

    // xóa kí tự đầu
    public String removeFirstCharacter(String input) {
        if (input == null || input.length() <= 1) {
            return ""; // Trả về chuỗi rỗng nếu input null hoặc có độ dài <= 1
        }
        return input.substring(1); // Lấy chuỗi từ vị trí thứ 1 đến hết (bỏ qua ký tự đầu tiên)
    }
// xoa 1 kí tự bất kì

    public String removeCharacterAt(String input, int index) {

        StringBuilder sb = new StringBuilder(input);
        sb.deleteCharAt(index);
        return sb.toString();
    }

}
