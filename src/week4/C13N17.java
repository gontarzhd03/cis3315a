package week4;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
class Complex implements Cloneable {
    // a + bi
    private double a; //real
    private double b; //imaginary

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public Complex(double a) {
        this.a = a;
        this.b = 0;
    }

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
    public Complex mul(Complex c) {
        return new Complex((a * c.getA() - b * c.getB()), (b * c.getA() + a * c.getB()));
    }
    public Complex div(Complex c) {
        return new Complex((a * c.getA() + b * c.getB()) / (c.getA() * c.getA() + c.getB() * c.getB()), (b * c.getA() - a * c.getB()) / (c.getA() * c.getA() + c.getB() * c.getB()));
    }
    public Complex abs(Complex c) {
        return new Complex(Math.sqrt(a * a + b * b));
    }

    @Override
    public String toString() {
        return b == 0 ? String.format("(%.4f)", a) : String.format("(%.4f + %.4fi)", a, b);
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class C13N17 {
    public void StartIt() throws CloneNotSupportedException {
        Complex rc;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        Complex c1 = new Complex(sc.nextDouble(), sc.nextDouble());
        System.out.print("Enter the second complex number: ");
        Complex c2 = new Complex(sc.nextDouble(), sc.nextDouble());
        rc = c1.add(c2);
        System.out.println(c1 + " + " + c2 + " = " + rc);
        
        rc = c1.sub(c2);
        System.out.println(c1 + " - " + c2 + " = " + rc);
        
        rc = c1.mul(c2);
        System.out.println(c1 + " * " + c2 + " = " + rc);

        rc = c1.div(c2);
        System.out.println(c1 + " / " + c2 + " = " + rc);
        
        rc = c1.abs(c2);
        System.out.println("|" + c1 + "| = " + rc.getA());
    }
    public static void main(String[] args) {
        try {
            C13N17 c13n17 = new C13N17();
            c13n17.StartIt();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
