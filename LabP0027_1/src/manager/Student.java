/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Student implements Serializable {

    private String id;
    private String name;
    private String email;
    private String phone;
    private int mountainCode;
    private double  tuition;

    public Student(String id, String name, String phone, String email , int mountainCode,double  tuition) {
        this.id = id;
        this.tuition = tuition;
        this.mountainCode = mountainCode;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(int mountainCode) {
        this.mountainCode = mountainCode;
    }

   

    public double  getTuitionFee() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    
     
    @Override
    public String toString(){
        return String.format("id: %s ,name: %s ,phone: %s ,email: %s ,mountainCode: %d ,tuitionFee: %.2f",
                         id, name, phone, email, mountainCode, tuition);}
}
