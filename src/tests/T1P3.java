package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


/**
 * Write 100 random ints to a text file; one int per line. Use a try with
 * resources and a catch block as needed. Add a finally block that prints the
 * words "All done".
 *
 * @author Hank Gontarz
 */
public class T1P3 {
    private String fileName = "Numbers.txt";
        
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
                tmp = String.format("%02d\r\n", rand.nextInt(100));
                writer.write(tmp);
            }
        } catch (IOException ex) {
            System.out.println("Failed to write to file: " + fileName);
            throw new IOException(ex);
        }
    }
    public void StartIt() {
        try {
            createFile();
            writeNumbers();
        } catch (IOException ex) {
            System.out.println("Program failure: " + ex.getMessage());
        }
        finally {
            System.out.println("All done");
        }
    }
    public static void main(String[] args) {
        T1P3 t1p3 = new T1P3();
        t1p3.StartIt();
    }
}
