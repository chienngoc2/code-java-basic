
package luyentap;


public class Zebra {
 private  String owner;
 private int weight;

    public Zebra() {
    }

    public Zebra(String owner, int weight) {
        this.owner = owner;
        this.weight = weight;
    }

    public String getOwner() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < owner.length(); i++) {
            char c = owner.charAt(i);
            if (Character.isLetter(c) ||(Character.isDigit(c) && c % 2 != 0)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight - this.owner.length();
    }
  
    
}
