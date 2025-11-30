
package q2;


public class Zebra {
   private String owner;
   private  int weight;

    public Zebra() {
    }

    public Zebra(String owner, int weight) {
        this.owner = owner;
        this.weight = weight;
    }

     // Phương thức loại bỏ các ký tự số chẵn trong chuỗi owner
    public String getOwner() {
     StringBuilder result = new StringBuilder();
        for (int i = 0; i < owner.length(); i++) {
            char c = owner.charAt(i);
            if (!Character.isDigit(c) || c % 2 != 0) {
                result.append(c);
                
            }
         }
     return result.toString();
    }

   
    public int getWeight() {
        return weight - owner.length();
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
   
   
}
