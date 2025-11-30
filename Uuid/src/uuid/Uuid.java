
package uuid;

import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public class Uuid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String uuid = UUID.randomUUID().toString();
        int hash = Math.abs(uuid.hashCode()); // Convert UUID to positive integer
        String number = String.format("%06d", hash % 1000000); // Get the last 6 numbers
        System.out.println("UUID: " + uuid);
        String id = "SE_" +uuid;
        System.out.println("ID: "+ id);
    }
    
}
