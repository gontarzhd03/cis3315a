package chap9;

import java.util.Scanner;

/**
 *
 * @author Hank Gontarz
 */
public class PetAppMenu {
    Scanner sc = new Scanner(System.in);
    PetList data = new PetList();
    
    public PetAppMenu() {
        menuLoop();
    }
    public void menuLoop() {
        String choice = "1";
        int id;
        String species;
        double price;
        
        while(!choice.equals("0")) {
            System.out.println("\n Pet App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Records");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.print("Number of choice: ");
            choice = sc.nextLine();
            if(choice.equals("0")) {
            }
            else if(choice.equals("1")) {
                System.out.println(data.toString());
            }
            else if(choice.equals("2")) {
                System.out.print("Enter Pet Id: ");
                id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Species: ");
                species = sc.nextLine();
                System.out.print("Enter Price: ");
                price = Double.parseDouble(sc.nextLine());
                Pet pt = new Pet(id, species, price);
                data.create(pt);
            }
            else if(choice.equals("3")) {
                System.out.print("Enter Pet Id: ");
                id = Integer.parseInt(sc.nextLine());
                System.out.println(data.retrieve(id));
            }
            else if(choice.equals("4")) {
                
            }
            else if(choice.equals("5")) {
                System.out.print("Enter Pet Id To Delete: ");
                id = Integer.parseInt(sc.nextLine());
                data.delete(id);
            }
            else {
                System.out.println("Please enter a number between 0 and 5!");
            }
        }
    }
    public static void main(String[] args) {
        new PetAppMenu();
    }
    
}
