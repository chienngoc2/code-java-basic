
abstract public class Shape {

    private String borderColor;
    private String fillColor;

    public Shape(String borderColor, String fillColor) { // 1 usage
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    abstract public double getArea();
    abstract public double getPerimeter();

    public String getBorderColor() { // 1 usage
        return borderColor;
    }

    public void setBorderColor(String borderColor) { // no usages
        this.borderColor = borderColor;
    }

    public String getFillColor() { // 1 usage
        return fillColor;
    }

    public void setFillColor(String fillColor) { // no usages
        this.fillColor = fillColor;
    }

}
