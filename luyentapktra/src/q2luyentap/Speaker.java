
package q2luyentap;


public class Speaker {
   public  String name;
   public int power;

    public Speaker() {
    }

    public Speaker(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
   @Override
   public String toString(){
       return this.name+","+this.power;
   }
}
