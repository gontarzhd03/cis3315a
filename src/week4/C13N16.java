package week4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
class Fraction {
    private int whole;
    private int numerator;
    private int denominator;

    public Fraction() {
        whole = 0;
        numerator = 0;
        denominator = 0;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(String word) throws Exception {
        String[] frac = word.split("/");
        if(frac.length > 1) {
            numerator = Integer.parseInt(frac[0]);
            denominator = Integer.parseInt(frac[1]);
            if(denominator == 0) throw new Exception("Denominator can't be zero");
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
        return whole > 0 ? numerator == 0 ? "" + whole : whole + " " + numerator + "/" + denominator : numerator + "/" + denominator;
    }
    private void FixWhole() {
        if(numerator >= denominator) {
            whole = numerator / denominator;
            numerator %= denominator;
            if(numerator == 0) denominator = 0;
        }
    }
    private Fraction Simplify(Fraction in) {
        int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
            67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
            139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199 };
        Fraction rc = new Fraction();
        
        rc.setNumerator(in.getNumerator());
        rc.setDenominator(in.getDenominator());
        for(int i = 0; i < primes.length; i++) {
            while(rc.getDenominator() % primes[i] == 0 && rc.getNumerator() % primes[i] == 0) {
                rc.setNumerator(rc.getNumerator() / primes[i]);
                rc.setDenominator(rc.getDenominator() / primes[i]);
            }
        }
        rc.FixWhole();
        return rc;
    }
    public Fraction Add(Fraction in) {
        if(getDenominator() == in.getDenominator()) {
            return Simplify(new Fraction(getNumerator() + in.getNumerator(), in.getDenominator()));
        }
        else {
            return Simplify(new Fraction(
                    getNumerator() * in.getDenominator() + in.getNumerator() * getDenominator(),
                    getDenominator() * in.getDenominator()));
        }
    }
    public Fraction Sub(Fraction in) {
        if(getDenominator() == in.getDenominator()) {
            return Simplify(new Fraction(getNumerator() - in.getNumerator(), in.getDenominator()));
        }
        else {
            return Simplify(new Fraction(
                    getNumerator() * in.getDenominator() - in.getNumerator() * getDenominator(),
                    getDenominator() * in.getDenominator()));
        }
    }
    public Fraction Mul(Fraction in) {
        return Simplify(new Fraction(
                getNumerator() * in.getNumerator(),
                getDenominator() * in.getDenominator()));
    }
    public Fraction Div(Fraction in) {
        return Simplify(new Fraction(
                getNumerator() * in.getDenominator(),
                getDenominator() * in.getNumerator()));
    }
}

public class C13N16 {
    private int operation;

    public void StartIt() throws Exception {
        int[] temp = {0, 0};
        String line;
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Fraction> fr = new ArrayList();
        System.out.print("Enter two separate fractions separated by an operator: ");
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
        switch(operation) {
            case 1:
               System.out.print(" = " + fr.get(0).Add(fr.get(1)) + "\n");
               break;
            case 2:
               System.out.print(" = " + fr.get(0).Sub(fr.get(1)) + "\n");
               break;
            case 3:
               System.out.print(" = " + fr.get(0).Mul(fr.get(1)) + "\n");
               break;
            case 4:
               System.out.print(" = " + fr.get(0).Div(fr.get(1)) + "\n");
               break;
        }
    }
    public static void main(String[] args) {
        try {
            C13N16 c13n16 = new C13N16();
            c13n16.StartIt();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
