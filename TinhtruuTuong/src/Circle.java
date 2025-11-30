
 public class Circle extends Shape {
    private double radius;

    public Circle(String borderColor, String fillColor, double radius) {
        super(borderColor, fillColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // phải dùng Override
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // phải dùng Override tại đây
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

