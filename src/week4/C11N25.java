package week4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author hgontarz
 */
public class C11N25 {
    public void readData() {
        String trash;
        double[] salarySum = {0.0, 0.0, 0.0};
        int[] salaryCount = {0, 0, 0};
        String urlnm = "http://cs.armstrong.edu/liang/data/Salary.txt";
        
        try {
            URL url = new URL(urlnm);
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
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
                        trash = sc.next();
                        break;
                }
            }
            System.out.printf("Assistant %.2f Associate %.2f Full %.2f\r\n",
                    salarySum[0], salarySum[1], salarySum[2]);
            System.out.printf("Average: Assistant %.2f Associate %.2f Full %.2f\r\n",
                    (salarySum[0] / salaryCount[0]),
                    (salarySum[1] / salaryCount[1]),
                    (salarySum[2] / salaryCount[2]));
        }    
        catch (MalformedURLException ex) {
            System.out.println("Failed to load URL: " + urlnm + " " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("Failed to read from stream");
        }
    }
    public void StartIt() {
        readData();
    }
    public static void main(String[] args) {
        C11N25 c12n25 = new C11N25();
        c12n25.StartIt();
    }
}
