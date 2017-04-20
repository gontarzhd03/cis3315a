package week11;

import java.util.Scanner;

/**
 *
 * @author 55gontarhd03
 */
public class BBApp {
    LinkedList2 list;
    
    public BBApp() {
        this.list = new LinkedList2();
        start();
    }
    public void start() {
        String choice = "";
        String regex = "^quit|add|delete|list$";
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            menu();
            choice = Validator.getLine(sc, "Enter your choice: ", regex);
            if(choice.equalsIgnoreCase("quit")) {
                break;
            }
            else if(choice.equalsIgnoreCase("add")) {
                String name = Validator.getLine(sc, "Enter friend's name: ");
                int rating = Validator.getInt(sc, "Enter rating: ");
                list.push(new Friend(name, rating));
            }
            else if(choice.equalsIgnoreCase("list")) {
                System.out.println(list);
            }
        }
    }
    public void menu() {
        System.out.println("\nHank's Black Book");
        System.out.println("Add - add a new friend");
        System.out.println("Remove - remove a new friend");
        System.out.println("List - display list of friends");
        System.out.println("Name - display list of friends by name");
        System.out.println("Reverse - display list of friends ordered by name descending");
        System.out.println("Rating - display list of friends by rating");
        System.out.println("Search - search for a display");
        System.out.println("Range - display list of friends by in a range of ratings");
        System.out.println("Quit");
    }
    public static void main(String[] args) {
        BBApp app = new BBApp();
    }
}
