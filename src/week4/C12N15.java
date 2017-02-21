package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Hank Gontarz
 */
public class C12N15 {
    private final String fileName = "Exercise1215.txt";
    private ArrayList<Integer> intlist;
    
    public void StartIt() {
        String tmp = "";
        String line;
        
        Random rand = new Random();
        intlist = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
        } catch (IOException ex) {
            System.out.println("");
        }
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(int i = 0; i < 100; i++) {
                tmp += String.format("%d ", rand.nextInt(100));
            }
            writer.write(tmp);
        } catch (IOException ex) {
            System.out.println("");
        }
        path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) continue;
                String[] data = line.split(" ");
                for(int i = 0; i < data.length; i++) {
                    intlist.add(Integer.parseInt(data[i]));
                }
            }
        } catch (IOException ex) {
            System.out.println("");
        }
        
    }
    public static void main(String[] args) {
        C12N15 c12n15 = new C12N15();
        c12n15.StartIt();
    }
}
