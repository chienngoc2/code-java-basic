package q3;

public class Wall {

    private String place;
    private int area;

    public Wall() {
    }

    public Wall(String place, int area) {
        this.place = place;
        this.area = area;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString()

    {
        return this.place+","+ this.area;
    }
}
