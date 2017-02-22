package week4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author hgontarz
 */
public class C12N19 {
    int WordCount = 0;
    String text = "";

    public C12N19() {
        
    }
    public boolean loadURL() {
        boolean rc = false;
        String urlnm = "http://cs.armstrong.edu/liang/data/Lincoln.txt";
        
        try {
            URL url = new URL(urlnm);
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
                text += sc.next();
                WordCount++;
            }
            rc = true;
        }
        catch (MalformedURLException ex) {
            System.out.println("Failed to load URL: " + urlnm + " " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("Scanner failed: " + ex.getMessage());
        }
        return rc;
    }
    public void StartIt() {
        if(loadURL()) {
            System.out.println("The word count is: " + WordCount);
        }
        else {
            System.out.println("loadURL failed!");
        }
    }
    public static void main(String[] args) {
        C12N19 c12n19 = new C12N19();
        c12n19.StartIt();
    }
}
