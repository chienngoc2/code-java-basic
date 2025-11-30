/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Rectangle {
    double length;
    double width;
    
    public Rectangle(){
    }
    public Rectangle(double length,double width){
        this.length= length;
        this.width= width;
    }
        public double getWidth(){
            return width;
        }
        public void setWidth(double width){
            this.width = width;
        }
        public double getLength(){
            return length;
        }
        public void setLength(double length){
            this.length = length;
        }
        
        public void getArea() {
           double area= this.length *this.width;
           String areaFn = String.format("%.2f", area);
            System.out.println("Area = " + areaFn );
        }
        public void getPerimeter() {
           double perimeter = (this.length + this.width) *2;
           String perimeterFn = String.format("%.2f",perimeter);
            System.out.println("Perimeter = " + perimeterFn);
        }
}
