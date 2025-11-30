/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public class Inputter {

    private Scanner scanner;

//  Constructor
    public Inputter() {
        this.scanner = new Scanner(System.in);
    }

    // INPUT STRING
    public String getString() {
        return scanner.nextLine();
    }

    //INPUT NUMBER
    public int getInt() {
        return scanner.nextInt();
    }

    // INPUT CHOICE
    public String getChoiceCampus() {
        int choice = this.getInt();
        scanner.nextLine();
        while (choice < 1 || choice > 5) {
            System.out.println("Please enter a valid choice: ");
            choice = this.getInt();
             scanner.nextLine(); 
        }

        switch (choice) {
            case 1:
                return "SE";
            case 2:
                return "HE";
            case 3:
                return "QE";
            case 4:
                return "DE";
            case 5:
                return "CE";
            default:
                return "Invalid choice";
        }

    }

    public String getName() {
        String name = this.getString();

        while (!Acceptable.isValid(name, Acceptable.NAME_VALID)) {
            System.out.println("Invalid Name:");
            name = this.getString();;
        }
        return name;

    }

    public String getEmail() {
        String mail = this.getString();

        while (!Acceptable.isValid(mail, Acceptable.EMAIL_VAlID)) {
            System.out.println("Wrong account or password, please check again:");
            mail = this.getString();;
        }
        return mail;

    }
    public String getNumPhone() {
        String num = this.getString();

        while (!Acceptable.isValid(num, Acceptable.PHONE_VALID) && (!Acceptable.isValid(num,Acceptable.VIETTEL_VALID) || !Acceptable.isValid(num,Acceptable.VINA_VALID))) {
            System.out.println("Invalid Phone number:");
            num = this.getString();;
        }
        return num;

    }

    public String getID(String campus) {
        String id = UUID.randomUUID().toString();
        int hash = Math.abs(id.hashCode()); // Convert UUID to positive integer
        String number = String.format("%06d", hash % 1000000); // Get the last 6 numbers
        return campus + number;
    }
    
    public double  getTuitionCal(String phone) {
        double  tuition = 6000000;
        if(Acceptable.isValid(phone, Acceptable.VIETTEL_VALID) ||Acceptable.isValid(phone, Acceptable.VINA_VALID)){
            tuition = (tuition * 0.65);
        }
        return (int)tuition;
    }
}
