package data;

import java.io.*;
import java.util.ArrayList;
import manager.Order;

public class FeastOrderList extends ArrayList<Order> {
    private static final long serialVersionUID = 1L; // Đảm bảo tương thích khi lưu file
    private static final String filePath = "orders.dat";

    
   public static void writeToFile(FeastOrderList orderList) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
        oos.writeObject(orderList);
        System.out.println("Order data successfully saved to file.");
    } catch (IOException e) {
        System.out.println("Error saving order data: " + e.getMessage());
    }
}



    public static FeastOrderList readFromFile() {
    File file = new File(filePath);
    if (!file.exists()) {
        System.out.println("Order file not found. Returning an empty list.");
        return new FeastOrderList(); // Trả về danh sách rỗng nếu file không tồn tại
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
        FeastOrderList orderList = (FeastOrderList) ois.readObject();
        //((ArrayList<Order>) FeastOrderList).addAll(orderList);

        System.out.println("Order data successfully loaded from file.");
        return orderList;
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error while reading order data from file: " + e.getMessage());
        return new FeastOrderList(); // Nếu có lỗi, trả về danh sách rỗng
    }
}


   
    public Order getOrderByID(int id) {
        for (Order order : this) {
            if (order.getOrderID() == id) {
                return order;
            }
        }
        return null; // Không tìm thấy đơn hàng
    }
}
