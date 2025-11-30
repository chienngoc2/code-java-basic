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
    private static final String DEFAULT_FILE_PATH = "path/to/MountainList.csv"; 

    public MountainList() {
        super();
    }

    public static MountainList readFromFile(String filePath) {
        MountainList mountainList = new MountainList();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not exist: " + filePath);
            return mountainList; // Trả về danh sách rỗng
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // Bỏ qua dòng tiêu đề
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    int code = Integer.parseInt(fields[0].trim());
                    String mountainName = fields[1].trim();
                    String province = fields[2].trim();
                    String description = fields[3].trim();
                    mountainList.add(new Mountain(code, mountainName, province, description));
                }
            }
            System.out.println("The mountain list has been successfully read from the file!");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error when reading file:" + e.getMessage());
        }

        return mountainList;
    }
}
