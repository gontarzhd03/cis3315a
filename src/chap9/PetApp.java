package chap9;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hank Gontarz
 */
public class PetApp {
    public static void main(String[] args) {
        try {
/*
        PetArray pa = new PetArray();
        pa.create(new Pet(1, "Dog", 500.0));
        pa.create(new Pet(2, "Dog", 300.0));
        pa.create(new Pet(3, "Cat", 100.0));
*/
/*
        PetList pl = new PetList();
        pl.create(new Pet(1, "Dog", 500.0));
        pl.create(new Pet(2, "Dog", 300.0));
        pl.create(new Pet(3, "Cat", 100.0));
*/
            PetList pets = new PetList();
            System.out.println(pets);
//            pets.create(new Pet(3, "cat", 50));
            
        } catch (IOException ex) {
            Logger.getLogger(PetApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
