/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import manager.Student;

/**
 *
 * @author ADMIN
 */
public class Inputter {

    private static final Scanner sc = new Scanner(System.in);

//  Constructor
    public static Object objMenu(Object... options) {
        if (options == null || options.length == 0) { // Kiểm tra nếu danh sách rỗng
            System.out.println("There are no options to choose from!");
            return null;
        }
        int choice;
        do {
            for (int i = 0; i < options.length; i++) {
                System.out.println( options[i]);
            }
            choice = getInt("choose", 1, options.length);
        } while (choice < 1 || choice > options.length);
        return options[choice - 1];
    }

    // INPUT STRING
    public static String getString(String mess) {
        System.out.println(mess);
        return sc.nextLine();
    }

    //INPUT NUMBER
    public static int getInt(String prompt, int min, int max) {
        int result = 0;
        do {
            System.out.print(prompt + "[" + min + ", " + max + "]: ");
            result = Integer.parseInt(sc.nextLine().trim());
            if (result < min || result > max) {
                System.out.println("Value range: " + "[" + min + ", " + max + "]");
            }
        } while (result < min || result > max);
        return result;
    }

    // INPUT CHOICE
    public static String getName() {
        String name = getString("Enter the name:");

        while (!Acceptable.isValid(name, Acceptable.NAME_VALID)) {

            name = getString("Enter name again: ");;
        }
        return name;

    }

    public static String getEmail(List<Student> sList) {
        String mail;

        while (true) {
            mail = getString("Enter the Email: ");
            if (!Acceptable.isValid(mail, Acceptable.EMAIL_VAlID)) {
            System.out.println("Email have been used. Please enter again.");
            continue; // Nhập lại nếu email không hợp lệ
        }
            boolean isDuplicate = false;
            for (Student s : sList) {
                if (s.getEmail().equals(mail)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("This email is already registered.");
            } else {
                break;
            }
        }

        return mail;

    }

    public static String getNumPhone(List<Student> sList) {
        String num;
        while (true) {
            num = getString("Enter phone number: ");

            // Kiểm tra định dạng hợp lệ
            if (!Acceptable.isValid(num, Acceptable.VIETTEL_VALID)
                    && !Acceptable.isValid(num, Acceptable.VINA_VALID)
                    && !Acceptable.isValid(num, Acceptable.VIETNAMEMOBI_VALID)
                    && !Acceptable.isValid(num, Acceptable.MOBI_VALID)) {
                System.out.println("Invalid phone number format. Please enter again.");
                continue;
            }

            // Kiểm tra số điện thoại có bị trùng không
            boolean isDuplicate = false;
            for (Student s : sList) {
                if (s.getPhone().equals(num)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("This phone number is already registered. Please enter a different one.");
            } else {
                break;
            }
        }
        return num;
    }

    public static String getID(String campus) {
        String id = UUID.randomUUID().toString();
        int hash = Math.abs(id.hashCode()); // Convert UUID to positive integer
        String number = String.format("%06d", hash % 1000000); // Get the last 6 numbers
        return campus + number;
    }

    public static double getSaletionCal(String phone,double tuition) {
        
        if (Acceptable.isValid(phone, Acceptable.VIETTEL_VALID) || Acceptable.isValid(phone, Acceptable.VINA_VALID)) {
            tuition = (tuition * 0.65);
        }
        return tuition;
    }

    public static Student getStudent(String id, List<Student> sList) {
        for (Student s : sList) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
}
