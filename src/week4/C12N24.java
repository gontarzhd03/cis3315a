package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hgontarz
 */
public class C12N24 {
    private final String fileName = "Salary.txt";
    
    public void createFile() {
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
        }
    }
    public void writeData() {
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
        }
    }
    public void readData() {
        String trash;
        String line;
        double[] salarySum = {0.0, 0.0, 0.0};
        int[] salaryCount = {0, 0, 0};
        
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) continue;
                Scanner sc = new Scanner(line);
                trash = sc.next();
                trash = sc.next();
                switch (sc.next()) {
                    case "assistant":
                        salarySum[0] += sc.nextDouble();
                        salaryCount[0]++;
                        break;
                    case "associate":
                        salarySum[1] += sc.nextDouble();
                        salaryCount[1]++;
                        break;
                    case "full":
                        salarySum[2] += sc.nextDouble();
                        salaryCount[2]++;
                        break;
                    default:
                        break;
                }
            }
            System.out.printf("Assistant %.2f Associate %.2f Full %.2f\r\n",
                    salarySum[0], salarySum[1], salarySum[2]);
            System.out.printf("Average: Assistant %.2f Associate %.2f Full %.2f\r\n",
                    (salarySum[0] / salaryCount[0]),
                    (salarySum[1] / salaryCount[1]),
                    (salarySum[2] / salaryCount[2]));
        } catch (IOException ex) {
            System.out.println("Failed to read from file: " + fileName);
        }
    }
    public void StartIt() {
        createFile();
        writeData();
        readData();
    }
    public static void main(String[] args) {
        C12N24 c12n24 = new C12N24();
        c12n24.StartIt();
    }
}
