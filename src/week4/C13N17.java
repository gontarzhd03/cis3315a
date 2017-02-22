package week4;

/**
 *
 * @author 55gontarhd03
 */
class Complex implements Cloneable {
    // a + bi
    private double a; //real
    private double b; //imaginary

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
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
    
    public Complex add(Complex c) {
        return new Complex((a + c.getA()), (b + c.getB()));
    }
    public Complex sub(Complex c) {
        return new Complex((a - c.getA()), (b - c.getB()));
    }
    
}

public class C13N17 {
    public static void main(String[] args) {
        Complex c1 = new Complex(3.5, 5.5);
        
    }
}
