

/**
 *
 * @author ADMIN
 */
public class Car extends Vehicle {
    private String model;
    
     public Car(String brand,String year,String model){
         super(brand,year);
         this.model=model;
     }
    
    public void warnDagger() {
        System.out.println("Stop! Don't move this way");

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
        super.move();
    }
    
       @Override
    public String toString(){
        
        return super.toString();
    }
   
 
    
}

