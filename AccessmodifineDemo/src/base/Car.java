/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;


public class Car extends Vehicle{
    private int doors;

    public Car(int doors, String brand, String year) {
        super(brand, year);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
    public void checkModifierAccess() {
         System.out.println(this.getBrand());
    }
    
    
    
}
