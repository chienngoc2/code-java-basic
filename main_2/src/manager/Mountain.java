/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author ADMIN
 */
public class Mountain {
    private int mountainCode;
    private String mountain;
    private String province;
    private String description;
    private double  price;

    public Mountain(int mountainCode, String mountain, String province, String description,double price) {
        this.mountainCode = mountainCode;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(int mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %.1f", mountainCode, mountain, province, description.isEmpty() ? "" : description,price);
    }


}
