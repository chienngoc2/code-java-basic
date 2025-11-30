


public class MyUtilities implements IUtilities {

      @Override
    public int reverseNumber(int n) {
        String str = Integer.toString(n);  // Chuyển số thành chuỗi
        StringBuilder sb = new StringBuilder(str);  // Tạo StringBuilder từ chuỗi
        sb.reverse();  // Đảo ngược chuỗi
        return Integer.parseInt(sb.toString());  // Chuyển chuỗi đã đảo ngược về số nguyên
    }

    @Override
    public int countSpecialCharacter(String s) {
        int count = 0;  // Khởi tạo biến đếm
        for (int i = 0; i < s.length(); i++) {
            // Kiểm tra xem ký tự có phải là chữ cái hoặc số không
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                count++;  // Tăng biến đếm nếu là ký tự đặc biệt
            }
        }
        return count;  // Trả về số ký tự đặc biệt
    }
    
}
