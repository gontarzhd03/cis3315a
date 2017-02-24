package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Hank Gontarz
 */
class AWord {
    private String word;

    public AWord() {
    }

    public AWord(String word) {
        this.word = word;
    }
    public int getCharCount() {
        return word.length();
    }
    @Override
    public String toString() {
        return "AWord{" + "word=" + word + '}';
    }
}

class ALine {
    private String line;
    private ArrayList<AWord> wordslist;
    
    public ALine() {
        wordslist = new ArrayList();
    }

    public ALine(String line) {
        this.line = line;
        wordslist = new ArrayList();
        ParseLine();
    }
    private void ParseLine() {
        String[] words = line.split(" ");
        for(int i = 0; i < words.length; i++) {
            wordslist.add(new AWord(words[i]));
        }
    }
    public int getWordCount() {
        return wordslist.size();
    }
    public int getCharCount() {
        int totalChars = 0;
        
        for(int i = 0; i < wordslist.size(); i++) {
            totalChars += wordslist.get(i).getCharCount();
        }
        return totalChars;
    }

    @Override
    public String toString() {
        return "ALine{" + "line=" + line + '}';
    }
}

public class C12N13 {
    private ArrayList<ALine> linelist;
    
    public boolean LoadFile(String fileName) {
        boolean rc = false;
        String line;
        
        linelist = new ArrayList();
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while((line = reader.readLine()) != null) {
                linelist.add(new ALine(line));
                rc = true;
            }
        } 
        catch (IOException ex) {
            System.out.println("IO Exception in LoadFile");
        }
        return rc;
    }
    private int[] getSumWordCount() {
        int[] vals = {0, 0};
        
        for(int i = 0; i < linelist.size(); i++) {
            vals[0] += linelist.get(i).getWordCount();
            vals[1] += linelist.get(i).getCharCount();
        }
        return vals;
    }
    public String printStats() {        
        int[] wc = getSumWordCount();
        String rc = String.format("%d lines, %d words, %d characters", linelist.size(), wc[0], wc[1]);
        return rc;
    }
    public static void main(String[] args) {
        C12N13 c12n13 = new C12N13();
        if(args.length > 0 && !args[0].isEmpty()) {
            if(c12n13.LoadFile(args[0])) {
               System.out.println(c12n13.printStats());
            }
        }
        else {
            if(c12n13.LoadFile("Salary.txt")) {
               System.out.println(c12n13.printStats());
            }
        }
    }
}
