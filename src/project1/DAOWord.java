package project1;

import static Ch7Array.C7StatsStatic.avg;
import static Ch7Array.C7StatsStatic.sqrt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hank Gontarz
 */
public class DAOWord {
    private final int MIN = 0;
    private final int MAX = 1;
    private final int SUM = 2;
    private final int AVG = 0;
    private final int STDDEV= 1;
    
    private final String fileName = "WordsList.txt";
    private List<Word> wordlist;

    public DAOWord() {
        wordlist = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
        } catch (IOException ex) {
            Logger.getLogger(DAOWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        readlist();
    }
    public void create(Word word) {
        wordlist.add(word);
        writelist();
    }
    public Word retrieve(int id) {
        Word word = null;
        
        for (Word wd : wordlist) {
            if(wd.getId() == id) {
                word = wd;
                break;
            }
        }
        return word;
    }
    public void delete(int id) {
        Word wdtmp = null;
        
        for (Word wd : wordlist) {
            if(wd.getId() == id) {
                wdtmp = wd;
                break;
            }
        }
        wordlist.remove(wdtmp);
        writelist();
    }
    public void delete(Word word) {
        Word wdtmp = null;
        
        for (Word wd : wordlist) {
            if(wd.getId() == word.getId()) {
                wdtmp = wd;
                break;
            }
        }
        wordlist.remove(wdtmp);
        writelist();
    }
    public void update(Word word) {
        for (Word wd : wordlist) {
            if(wd.getId() == word.getId()) {
                wd.setWordType(word.getWordType());
                wd.setWord(word.getWord());
                wd.setDefinition(word.getDefinition());
                break;
            }
        }
        writelist();
    }
    public String orderByIdAsc() {
        wordlist.sort(Comparator.comparing(Word::getId));
        return this.toString();
    }
    public String orderByIdDesc() {
        wordlist.sort(Comparator.comparing(Word::getId).reversed());
        return this.toString();
    }
    public String orderByWordType() {
        wordlist.sort(Comparator.comparing(Word::getWordType));
        return this.toString();
    }
    public String orderByWord() {
        wordlist.sort(Comparator.comparing(Word::getWord));
        return this.toString();
    }
    public String orderByDefinition() {
        wordlist.sort(Comparator.comparing(Word::getDefinition));
        return this.toString();
    }
    public String orderByWordLen() {
        wordlist.sort(Comparator.comparing(Word::getLength));
        return this.toString();
    }
    public String getStats() {
        long[] statsLong = {Integer.MAX_VALUE, 0, 0}; //min, max, sum
        double[] statsDbl = {0.0, 0.0}; //avg, stddev
        double sumSquares = 0.0;
        
        int count = wordlist.size();
        for(Word wd : wordlist) {
            if(wd.getLength() < statsLong[MIN]) {
                statsLong[MIN] = wd.getLength();
            }
            if(wd.getLength() > statsLong[MAX]) {
                statsLong[MAX] = wd.getLength();
            }
            statsLong[SUM] += wd.getLength();
            sumSquares += (wd.getLength() * wd.getLength());
        }
        statsDbl[AVG] = (float)statsLong[SUM] / count; //avg
        statsDbl[STDDEV] = Math.sqrt((sumSquares - (statsLong[SUM] * statsLong[SUM]) / count) / (count - 1)); //stddev
        return String.format("min= %d, max= %d, sum= %d, avg= %.2f, stddev= %.2f",
               statsLong[MIN], statsLong[MAX], statsLong[SUM], statsDbl[AVG], statsDbl[STDDEV]);
    }
    private void readlist() {
        String line;
            
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) continue;
                String[] data = line.split("/");
                int id = Integer.parseInt(data[0]);
                String wordType = data[1];
                String theWord = data[2];
                String definition = data[3];

                wordlist.add(new Word(id, wordType, theWord, definition));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writelist() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(Word wd : wordlist) {
                writer.write(String.format("%d/%s/%s/%s\n", wd.getId(), wd.getWordType(), wd.getWord(), wd.getDefinition()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Word wd : wordlist) {
            sb.append(wd).append("\n");
        }
        return sb.toString();
    }
}
