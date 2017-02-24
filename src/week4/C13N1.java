package week4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
abstract class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
    }

    public GeometricObject(String color, boolean filled, Date dateCreated) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = dateCreated;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Triangle extends GeometricObject {
    private ArrayList<Double> sides;
    
    public Triangle() {
        super("white", false, new Date());
        sides = new ArrayList();
    }

    public Triangle(String color, boolean filled) {
        super(color, filled, new Date());
        sides = new ArrayList();
    }
    
    public Triangle(String color, boolean filled, ArrayList<Double> sides) {
        super(color, filled, new Date());
        this.sides = new ArrayList();
        this.sides = sides;
    }
    
    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled, new Date());
        this.sides.add(side1);
        this.sides.add(side2);
        this.sides.add(side3);
    }
    
    @Override
    public double getPerimeter() {
        return (sides.get(0) + sides.get(1) + sides.get(2));
    }
    
    public double getSemiPerimeter() {
        return getPerimeter() / 2.0;
    }
    
    @Override
    public double getArea() {
        double s = getSemiPerimeter();
        double val = s * (s - sides.get(0)) * (s - sides.get(1)) * (s - sides.get(2));
        return Math.sqrt(val);
    }

    @Override
    public String toString() {
        return "Triangle {" + "sides=" + sides + ", area=" + getArea() + ", perimeter=" + getPerimeter() + ", " + super.toString() + '}';
    }
}

public class C13N1 {
    public void StartIt() {
        boolean isfilled = false;
        ArrayList<Double> sides = new ArrayList();
        String color;
        String line;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lengths of three sides of a triangle: ");
        line = sc.nextLine();
        String[] items = line.split(" ");
        for(int i = 0; i < items.length; i++) {
            if(i < 3) {
               sides.add(Double.parseDouble(items[i]));
            }
        }
        System.out.print("Enter the color of the triangle: ");
        color = sc.nextLine().toLowerCase();
        System.out.print("Is the triangle filled (y/n): ");
        line = sc.nextLine();
        isfilled = line.equalsIgnoreCase("yes");
        isfilled = line.equalsIgnoreCase("y");
        Triangle tr1 = new Triangle(color, isfilled, sides);
        if(tr1.getArea() <= 0) {
            System.out.println("One or more of the side lengths are invalid!");
        }
        else {
            System.out.println(tr1);
        }
    }
    public static void main(String[] args) {
        C13N1 c13n1 = new C13N1();
        c13n1.StartIt();
    }
}
