
public class Vehicle {

    private String brand;
    private String year;

    public Vehicle(String brand, String year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void move() {
        System.out.println("Moving....");
    }

    public void setPrice() {
        int au = 1000000;
        int toyota = 1000;
        if (this.brand == "audi") {
            System.out.println("price audi = " + au);
        } else if (this.brand == "toyota") {
            System.out.println("price toyota = " + toyota);
        } else {
            System.out.println("IDK");
        }
       
    }
     @Override
        public String toString() {
        return "Info the brand" + this.brand + "the year" + this.year;
        }

}
