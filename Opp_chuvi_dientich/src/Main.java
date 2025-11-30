
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // nhập giá trị
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Length: ");
        double l = sc.nextDouble();
        System.out.print("Enter the Width: ");
        double w = sc.nextDouble();

        // main
        Rectangle rect = new Rectangle();
        rect.setLength(l);
        rect.setWidth(w);
        System.out.println("length = " + rect.getLength());
        System.out.println("width = " + rect.getWidth());
        
        rect.getArea();
        rect.getPerimeter();
        
    }

}
