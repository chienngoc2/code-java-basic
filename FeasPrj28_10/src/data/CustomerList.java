package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import manager.Customer;
import manager.Feast;

public class CustomerList extends ArrayList<Customer> {

    private static final long serialVersionUID = 1L; // Giữ giá trị này cố định

    private static final String filePath = "Customer.dat";

    private List<Customer> customers = new ArrayList<>();

    public static void writeToFile(CustomerList customerList){
    
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customerList); // Ghi toàn bộ danh sách vào file
            oos.close();
            fos.close();
            System.out.println("Data successfully saved to file.");
        } catch (IOException e) {
            System.err.println("Error while saving data to file.");
            e.printStackTrace();
        }
    }

    public static CustomerList readFromFile() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            CustomerList customerList = (CustomerList) ois.readObject(); // Đọc danh sách từ file
            ois.close();
            fis.close();
            System.out.println("Data successfully loaded from file.");
            return customerList;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while reading data from file.");
            e.printStackTrace();
        }
        return new CustomerList(); // Nếu lỗi, trả về danh sách rỗng
    }

    public Customer getCusByCode(String code) {
        for (Customer c : this) {
            if (c.getCustomerCode().equalsIgnoreCase(code)) { // Sử dụng equalsIgnoreCase
                return c;
            }
        }
        return null;
    }

}
