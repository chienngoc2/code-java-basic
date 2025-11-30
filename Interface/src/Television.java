public class Television implements Remove, SmartDevice {   
    private String brand;   
    private String model;   

    public Television(String brand, String model) {   
        this.brand = brand;   
        this.model = model;   
    }   

    @Override   
    public String turnOn() {   
        return "The TV is ON";   
    }   

    @Override   
    public String turnOff() {   
        return "The TV is OFF";   
    }   

    @Override   
    public String connectToWifi() {   
        return "The TV is connected to WiFi";   
    }   

    @Override   
    public String connectToBluetooth() {   
        return "The TV is connected to Bluetooth";   
    }   

    @Override   
    public String connectToMobleData() {   
        return "The TV is connected to Mobile Data";   
    }   

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    
}