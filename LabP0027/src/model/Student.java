/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Student {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String mountainCode;
    private int tuitionFee;

    public Student(String id, String name, String email, String phone, String mountainCode, int tuitionFee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
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

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    
     
    @Override
    public String toString(){
      return "id: "+id+" name: "+name+" phone: "+phone+" email: "+email+" mountainCode: "+ mountainCode+" tuitionFee: "+tuitionFee;
}
}
