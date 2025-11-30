/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base2;

import base.Vehicle;
public class Bite extends Vehicle {
    private int wheel;

    public Bite(int wheel, String brand, String year) {
        super(brand, year);
        this.wheel = wheel;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }
    
    public void checkModifierAccess(){
        System.out.println(brand);
    }
    
    
    
}
