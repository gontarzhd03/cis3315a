package week4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hgontarz
 */
class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(String word) {
        String[] frac = word.split("/");
        if(frac.length > 1) {
            numerator = Integer.parseInt(frac[0]);
            denominator = Integer.parseInt(frac[1]);
        }
    }
    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public String toString() {
        return "Fraction{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
    }
    public Fraction Add(Fraction in) {
        if(getDenominator() == in.getDenominator()) {
            return new Fraction(getNumerator() + in.getNumerator(), in.getDenominator());
        }
        else {
            // not sure what do do!
        }
    }
}
public class C13N16 {
    private int operation;
        
    public boolean splitFraction(String word, int[] numdem) {
        boolean rc = false;
        
        String[] frac = word.split("/");
        if(frac.length > 1) {
            numdem[0] = Integer.parseInt(frac[0]);
            numdem[1] = Integer.parseInt(frac[1]);
            rc = true;
        }
        return rc;
    }
    public void StartIt() {
        int[] temp = {0, 0};
        String line;
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Fraction> fr = new ArrayList();
        System.out.println("Enter two separate fractions: ");
        line = sc.nextLine();
        String[] items = line.split(" ");
        for(int i = 0; i < items.length; i++) {
            switch(i) {
                case 0:
                    fr.add(new Fraction(items[i]));
                    break;
                case 1:
                    switch(items[i]) {
                        case "+":
                            operation = 1;
                            break;
                        case "-":
                            operation = 2;
                            break;
                        case "*":
                            operation = 3;
                            break;
                        case "/":
                            operation = 4;
                            break;
                    }
                    break;
                case 2:
                    fr.add(new Fraction(items[i]));
                    break;
            }
        }
        
    }
    public static void main(String[] args) {
        C13N16 c13n16 = new C13N16();
        c13n16.StartIt();
    }
}
