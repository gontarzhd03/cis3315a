package week4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hank Gontarz
 */
public class C12N24 {
    private final String fileName = "Salary.txt";
    
    public void createFile() throws Exception {
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
            throw new Exception(ex.getMessage());
        }
    }
    public void writeData() throws Exception {
        int iRank;
        int salary = 0;
        String tmp;
        String[] rank = {"assistant", "associate", "full"};
        
        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(int i = 0; i < 1000; i++) {
                iRank = rand1.nextInt(3);
                switch(iRank) {
                    case 0: //50,000 - 80,000 = 30,000
                        salary = rand2.nextInt(30000) + 50000;
                        break;
                    case 1: //60,000 - 110,000 = 50,000
                        salary = rand2.nextInt(50000) + 60000;
                        break;
                    case 2: //75,000 - 130,000 = 55,000
                        salary = rand2.nextInt(55000) + 75000;
                        break;
                }
                tmp = String.format("FirstName%03d LastName%03d %10s %6d.%02d\r\n", i, i,
                        rank[iRank],
                        salary,
                        rand3.nextInt(100));
                writer.write(tmp);
            }
        } catch (IOException ex) {
            System.out.println("Failed to write to file: " + fileName);
            throw new Exception(ex.getMessage());
        }
    }
    public void StartIt() {
        try {
            createFile();
            writeData();
            System.out.println(fileName + " was successfully created!");
        } catch (Exception ex) {
            Logger.getLogger(C12N24.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        C12N24 c12n24 = new C12N24();
        c12n24.StartIt();
    }
}
