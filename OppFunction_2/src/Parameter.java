
public class Parameter {

    double a, b, c;

    public Parameter() {
    }

    public Parameter(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void findResultFunc() {
        double delta, result;

        if (a == 0) {
            result = -c / b;
            System.out.println("result = " + result);
        } else if (a != 0) {
            delta = Math.pow(b, 2) - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / 2 * a;
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (delta == 0) {
                result = -b / (2 * a);
                System.out.println("result = " + result);
            } else if (delta < 0) {
                System.out.println("Errol.Can't find the result");
            }
        }
    }
}
