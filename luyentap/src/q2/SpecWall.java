
package q2;


public class SpecWall extends Wall {
    private String color;

    public SpecWall() {
    }

    public SpecWall(String color) {
        this.color = color;
    }

    public SpecWall( String place, int area,String color) {
        super(place, area);
        this.color = color;
    }
    
    @Override
    public String toString(){
        return super.getPlace()+", "+this.color+", "+super.getArea();
    }
    
    /*public void setData(){
        String result = super.getPlace().replaceAll("[^a-zA-Z]","");
        super.setPlace(result);
    }*/
    // chỉ giữ lại kí tự
    public void setData(){
        StringBuilder newPlace= new StringBuilder();
        for (int i = 0; i < super.getPlace().length(); i++) {
            char c = super.getPlace().charAt(i);
            if (Character.isLetter(c)) {
                newPlace.append(c);
            }
            
        }super.setPlace(newPlace.toString());
    }
    public String getValue(){
        int kq = super.getArea() / super.getPlace().length();
        if ( super.getArea() % super.getPlace().length() != 0 ) {
           return color ; 
        } else {
            return color + kq;
        }
        
    }
    
    
}
