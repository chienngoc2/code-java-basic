/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

/**
 *
 * @author ADMIN
 */
public class SpecWall extends Wall  {
    private  String color;

    public SpecWall() {
    }

    public SpecWall(String color) {
        this.color = color;
    }

    public SpecWall( String place, int area,String color) {
        super(place, area);
        this.color = color;
    }
    @Override
    public String toString(){
        return super.getPlace()+", "+this.color+", "+super.getArea();
    }
    public void setData(){
        String result;
        result = super.getPlace().replaceAll("[^a-zA-Z]","");
        super.setPlace(result);
    }
    public String getValue(){
        int kq;
         kq = super.getArea() / super.getPlace().length() ;
         return (super.getArea() % super.getPlace().length() !=0) ? this.color : this.color + kq;
    }
    
    
   
}

