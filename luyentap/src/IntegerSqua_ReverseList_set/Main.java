
package IntegerSqua_ReverseList_set;

import java.util.ArrayList;
import java.util.List;
public class Main {
      public static void main(String[] args) {
        // Tạo danh sách các đối tượng Wall
        List<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall("A123", 7));  // Độ dài place là 4, số chính phương
        wallList.add(new Wall("B", 2));
        wallList.add(new Wall("C12", 10));
        wallList.add(new Wall("D1", 5));
        wallList.add(new Wall("E234", 15));
        wallList.add(new Wall("G", 8));

        // Tạo đối tượng MyWall
        MyWall myWall = new MyWall();

        // Kiểm tra f1
        System.out.println("Diện tích nhỏ nhất với độ dài place là số chính phương: " + myWall.f1(wallList));

        // Kiểm tra f2 (đảo ngược phần tử thứ 4 đến 6)
        System.out.println("Trước f2: " + wallList);
        myWall.f2(wallList);
        System.out.println("Sau f2: " + wallList);

        // Kiểm tra f3 (thay thế phần tử đầu tiên bằng phần tử có diện tích nhỏ nhất)
        myWall.f3(wallList);
        System.out.println("Sau f3: " + wallList);
    }
}
