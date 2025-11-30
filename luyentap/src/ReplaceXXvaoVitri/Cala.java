
package ReplaceXXvaoVitri;


public class Cala {
   private String owner;
   private int price;

    public Cala() {
    }

    public Cala(String owner, int price) {
        this.owner = owner;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
   
    @Override
    public String toString(){
        return this.owner+","+this.price;
    }
}
