package chap9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hank Gontarz
 */
public class PetList {
    private final String fileName = "PetData.txt";
    private List<Pet> mylist;

    public PetList() {
        mylist = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
        } catch (IOException ex) {
            Logger.getLogger(PetList.class.getName()).log(Level.SEVERE, null, ex);
        }
        readlist();
    }

    public void create(Pet pet) {
        mylist.add(pet);
        writelist();
    }
    public Pet retrieve(int id) {
        Pet pet = null;
        
        for (Pet pt : mylist) {
            if(pt.getId() == id) {
                pet = pt;
                break;
            }
        }
        return pet;
    }
    public void delete(int id) {
        for (Pet pt : mylist) {
            if(pt.getId() == id) {
                mylist.remove(pt);
            }
        }
        writelist();
    }
    private void readlist() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String species = data[1];
                double price = Double.parseDouble(data[2]);
                Pet pet = new Pet(id, species, price);
                mylist.add(pet);
            }
        } catch (IOException ex) {
            Logger.getLogger(PetList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writelist() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(Pet pt : mylist) {
                writer.write(String.format("%d,%s,%.2f\n", pt.getId(), pt.getSpecies(), pt.getPrice()));
            }
        } catch (IOException ex) {
            Logger.getLogger(PetList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Pet pt : mylist) {
            sb.append(pt).append("\n");
        }
        return sb.toString();
    }
}
