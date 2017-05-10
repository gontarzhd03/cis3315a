package project1;

import java.util.Scanner;
import utilities.Prompt;

/**
 * 
 * @author Hank Gontarz
 */
public class WordApp {
    Scanner sc = new Scanner(System.in);
    DAOWord data = new DAOWord();
    
    public WordApp() {
        menuLoop();
    }

    public void menuLoop() {
        int choice = 1;
        int id;
        String wordType;
        String theWord;
        String definition;
        
        while(choice != 0) {
            System.out.println("\nElectronic Dictionary App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Records");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id Ascending");
            System.out.println("7 = Retrieve All: Order by Id Descending");
            System.out.println("8 = Retrieve All: Order by Word Type");
            System.out.println("9 = Retrieve All: Order by Word");
            System.out.println("10 = Retrieve All: Order by Definition");
            System.out.println("11 = Retrieve All: Order by Word Length");
            System.out.println("12 = Show Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 12);

            if(choice == 1) {
                System.out.println(data.toString());
            }
            else if(choice == 2) {
                id = Prompt.getInt("Enter Word Id: ");
                wordType = Prompt.getLine("Enter Word Type: ");
                theWord = Prompt.getLine("Enter The Word: ");
                definition = Prompt.getLine("Enter Word Definition: ");

                data.create(new Word(id, wordType, theWord, definition));
            }
            else if(choice == 3) {
                id = Prompt.getInt("Enter Word Id: ");
                System.out.println(data.retrieve(id));
            }
            else if(choice == 4) {
                id = Prompt.getInt("Enter Word Id: ");
                wordType = Prompt.getLine("Enter Word Type: ");
                theWord = Prompt.getLine("Enter The Word: ");
                definition = Prompt.getLine("Enter Word Definition: ");

                data.update(new Word(id, wordType, theWord, definition));
            }
            else if(choice == 5) {
                id = Prompt.getInt("Enter Word Id To Delete: ");
                data.delete(id);
            }
            else if(choice == 6) {
                System.out.println(data.orderByIdAsc());
            }
            else if(choice == 7) {
                System.out.println(data.orderByIdDesc());
            }
            else if(choice == 8) {
                System.out.println(data.orderByWordType());
            }
            else if(choice == 9) {
                System.out.println(data.orderByWord());
            }
            else if(choice == 10) {
                System.out.println(data.orderByDefinition());
            }
            else if(choice == 11) {
                System.out.println(data.orderByWordLen());
            }
            else if(choice == 12) {
                System.out.println(data.getStats());
            }
        }
    }

    public static void main(String[] args) {
        new WordApp();
    }
}
