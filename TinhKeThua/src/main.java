
public class main {

    
    public static void main(String[] args) {
        Vehicle vehicle_1 = new Vehicle("audi","2023");
        vehicle_1.move();
        
        System.out.println("brand = " + vehicle_1.getBrand());
        System.out.println("year = " + vehicle_1.getYear());
        System.out.println("vehicle = " + vehicle_1.toString());
        // using car class
        System.out.println("------------------------------");
        Car carOne = new Car("audi","2023","apple");
        
        
        carOne.setPrice();
        carOne.warnDagger();
        carOne.move();
        System.out.println("brand = " + carOne.getBrand());
        System.out.println("year= " + carOne.getYear());
        System.out.println("model = " + carOne.getModel());
        System.out.println("info = " + carOne.toString());
        
    }
    
}
