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
import manager.Feast;




public class FMenuList  extends ArrayList<Feast> {

    private static final String DEFAULT_FILE_PATH = "feastMenu.csv";

    public FMenuList() {
    }

  

    public static FMenuList readFromFile() {
        return readFromFile(DEFAULT_FILE_PATH);
    }

    public Feast getFeastByCode(String code) {
        for (Feast m : this) { 
            if (m.getFeastCode().equalsIgnoreCase(code)) {
                return m;
            }
        }
        return null; // Nếu không tìm thấy
    }

    public static FMenuList readFromFile(String filePath) {
        FMenuList fMenuList = new FMenuList();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not exist: " + filePath);
            return fMenuList;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // bỏ qua dòng tiêu đề
            String line;
            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(","); 
                if (fields.length < 4) {
                    System.out.println("Invalid line, skipping: " + line);
                    continue;
                }

                try {
                    String code = fields[0].trim();
                    String name = fields[1].trim();
                    int price = Integer.parseInt(fields[2].trim());
                    String ingredients = fields[3].trim();
                     ingredients = ingredients.replace("#", "\n  - ");
                    

                    fMenuList.add(new Feast(code,name,price,ingredients));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing number in line: " + line);
                }
            }
            System.out.println("Successfully read list!");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return fMenuList;
    }
}


