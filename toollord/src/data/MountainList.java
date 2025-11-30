/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import manager.Mountain;

/**
 *
 * @author ADMIN
 */
public class MountainList extends ArrayList<Mountain> {

    private static final String DEFAULT_FILE_PATH = "MountainList.csv";

    public MountainList() {
        super();
    }

    public static MountainList readFromFile() {
        return readFromFile(DEFAULT_FILE_PATH);
    }

    public Mountain getMountainByCode(int code) {
        for (Mountain m : this) { 
            if (m.getMountainCode() == code) {
                return m;
            }
        }
        return null; // Nếu không tìm thấy
    }

    public static MountainList readFromFile(String filePath) {
        MountainList mountainList = new MountainList();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not exist: " + filePath);
            return mountainList;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // bỏ qua dòng tiêu đề
            String line;
            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",", -1); // -1 để giữ giá trị rỗng
                if (fields.length < 5) {
                    System.out.println("Invalid line, skipping: " + line);
                    continue;
                }

                try {
                    int idCode = Integer.parseInt(fields[0].trim());
                    String mountainName = fields[1].trim();
                    String province = fields[2].trim();
                    String description = fields[3].trim().isEmpty() ? "No description available" : fields[3].trim();
                    double price = fields[4].trim().isEmpty() ? 0 : Integer.parseInt(fields[4].trim()); // Giá mặc định là 0 nếu trống

                    mountainList.add(new Mountain(idCode, mountainName, province, description, price));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing number in line: " + line);
                }
            }
            System.out.println("Successfully read mountain list!");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return mountainList;
    }
}
