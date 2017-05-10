package project1;

/**
 *
 * @author Hank Gontarz
 */
public class Word {
    private int id;
    private int Length;
    private String WordType;
    private String Word;
    private String Definition;

    public Word() {
    }

    public Word(int id, String WordType, String Word, String Example) {
        this.id = id;
        this.Length = Word.length();
        this.WordType = WordType;
        this.Word = Word;
        this.Definition = Example;
    }

    public String getDefinition() {
        return Definition;
    }

    public void setDefinition(String Definition) {
        this.Definition = Definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordType() {
        return WordType;
    }

    public void setWordType(String WordType) {
        this.WordType = WordType;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String Word) {
        this.Word = Word;
        this.Length = Word.length();
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }
    
    @Override
    public String toString() {
        return String.format("Id= %3d, Len= %3d, Type= %10s, Word= %14s, Def= %s", id, Length, WordType, Word, Definition);
//        return "Word{" + "id=" + id + ", WordType=" + WordType + ", Word=" + Word + ", Definition=" + Definition + '}';
    }
}
