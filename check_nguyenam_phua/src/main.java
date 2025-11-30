import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi cần đếm: ");
        String text = scanner.nextLine();

        CharacterCounter counter = new CharacterCounter(text);
        counter.countCharacters();
        counter.displayCounts();

        scanner.close();
    }
}