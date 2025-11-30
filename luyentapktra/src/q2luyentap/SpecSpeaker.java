
package q2luyentap;

public class SpecSpeaker extends Speaker {
    private String sound;

    public SpecSpeaker() {
    }

    public SpecSpeaker(String sound) {
        this.sound = sound;
    }

    public SpecSpeaker( String name, int power,String sound) {
        super(name, power);
        this.sound = sound;
    }
    public void setData(){
        this.name= this.name.substring(1);
    }
    public String getValue(){
        if (this.power > 10) {
            return this.sound+this.power;
        }
        else {
            return this.sound;
        }
    }
    @Override
    public String toString(){
        return this.name+","+this.sound+","+this.power;
    }
}
