import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print(" Enter parameter a= " );
        double a = sc.nextDouble();
        
        System.out.print(" Enter parameter b= " );
        double b = sc.nextDouble();
        
        System.out.print(" Enter parameter c= " );
        double c = sc.nextDouble();
        
        Parameter par = new Parameter() ;
        // set up giá trị
        par.setA(a);
        par.setB(b);
        par.setC(c);
        // check again
        System.out.println("a =" + par.getA());
        System.out.println("b =" + par.getB());
        System.out.println("c =" + par.getC());
        
        par.findResultFunc();
        
        
    }
    
}
