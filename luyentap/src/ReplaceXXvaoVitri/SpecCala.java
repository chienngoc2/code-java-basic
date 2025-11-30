package ReplaceXXvaoVitri;

class SpecCala extends Cala {

    private int color;

    public SpecCala() {
    }

    public SpecCala(int color, String owner, int price) {
        super(owner, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getOwner() + "," + this.getPrice() + "," + this.color;
    }

    public void setData() {
        if (getOwner().length() > 1) {
            setOwner(getOwner().substring(0, 1) + "XX" + getOwner().substring(2));
        }
    }

    public int getValue() {

        if (color % 2 != 0) {
            return getPrice() + 3;
        } else {
            return getPrice() + 7;
        }

    }
}


    
    
    

