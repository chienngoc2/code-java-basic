
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Television television = new Television("Sony", "Bravia");
        System.out.println(television.turnOn());
        System.out.println(television.turnOff());
        System.out.println(television.connectToWifi());
        System.out.println(television.connectToBluetooth());
        System.out.println(television.connectToMobleData());
    }

}
