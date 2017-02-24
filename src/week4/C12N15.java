package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hank Gontarz
 */
public class C12N15 {
    private final String fileName = "Exercise1215.txt";
    private final ArrayList<Integer> intlist;

    public C12N15() {
        intlist = new ArrayList();
    }
    public void createFile() throws IOException {
        File input = new File(fileName);
        try {
            if(input.exists()) {
               input.delete();
               Files.createFile(Paths.get(fileName));
            }
            else {
               Files.createFile(Paths.get(fileName));
            }
        }
        catch (IOException ex) {
            System.out.println("Failed to create file: " + fileName);
            throw new IOException(ex);
        }
    }
    public void writeNumbers() throws IOException {
        String tmp = "";
        
        Random rand = new Random();
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(int i = 0; i < 100; i++) {
                tmp += String.format("%d ", rand.nextInt(100));
            }
            writer.write(tmp);
        } catch (IOException ex) {
            System.out.println("Failed to write to file: " + fileName);
            throw new IOException(ex);
        }
    }
    public void readNumbers() throws IOException {
        String line;
        
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) continue;
                String[] data = line.split(" ");
                for (String data1 : data) {
                    intlist.add(Integer.parseInt(data1));
                }
            }
        } catch (IOException ex) {
            System.out.println("Failed to read from file: " + fileName);
            throw new IOException(ex);
        }
    }
    public void sortNumbers() {
        intlist.sort((Integer n1, Integer n2) -> n1 - n2);
    }
    public void displayNumbers() {        
        for(int i = 1; i <= intlist.size(); i++) {
            if(i % 10 == 0) {
                System.out.printf("%2d ", intlist.get(i-1));
                System.out.println("");
            }
            else {
                System.out.printf("%2d ", intlist.get(i-1));
            }
        }
        System.out.println("");
    }
    public void StartIt() {
        try {
            createFile();
            writeNumbers();
            readNumbers();
            sortNumbers();
            displayNumbers();
        } catch (IOException ex) {
            Logger.getLogger(C12N15.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        C12N15 c12n15 = new C12N15();
        c12n15.StartIt();
    }
}
