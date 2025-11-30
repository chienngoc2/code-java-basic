
public class CharacterCounter {
 
    private String text;
    private int vowelCount;
    private int consonantCount;

    // Constructor để khởi tạo đối tượng với chuỗi văn bản
    public CharacterCounter(String text) {
        this.text = text.toLowerCase(); // Chuyển chuỗi thành chữ thường
        this.vowelCount = 0;
        this.consonantCount = 0;
    }

    // Phương thức để đếm nguyên âm và phụ âm
    public void countCharacters() {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) { // Kiểm tra nếu ký tự là chữ cái
                if (isVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
    }

    // Phương thức kiểm tra ký tự có phải là nguyên âm không
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    // Phương thức hiển thị kết quả
    public void displayCounts() {
        System.out.println("Số nguyên âm: " + vowelCount);
        System.out.println("Số phụ âm: " + consonantCount);
    }
}

