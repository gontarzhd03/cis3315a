package chap6;

/**
 *
 * @author Hank Gontarz
 */
public class C6N38RandChar {
    private final MainClass mc;
    
    public class RandomCharacter {
        public char getRandomCharacter(char ch1, char ch2) {
            return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
        }
        public char getRandomLowerCaseLetter() {
            return getRandomCharacter('a', 'z');
        }
        public char getRandomUpperCaseLetter() {
            return getRandomCharacter('A', 'Z');
        }
        public char getRandomDigitCharacter() {
            return getRandomCharacter('0', '9');
        }
        public char getRandomCharacter() {
            return getRandomCharacter('\u0000', '\uFFFF');
        }
    }
    public class MainClass {
        final int NUMBER_OF_CHARS = 100;
        final int CHARS_PER_LINE = 10;
        
        public void StartIt() {
            RandomCharacter rc = new RandomCharacter();
            for(int i = 0; i < NUMBER_OF_CHARS; i++) {
                char ch = rc.getRandomUpperCaseLetter();
                if((i + 1) % CHARS_PER_LINE == 0) {
                    System.out.println(ch);
                }
                else {
                    System.out.print(ch);
                }
            }
            System.out.println("");
            for(int i = 0; i < NUMBER_OF_CHARS; i++) {
                char ch = rc.getRandomDigitCharacter();
                if((i + 1) % CHARS_PER_LINE == 0) {
                    System.out.println(ch);
                }
                else {
                    System.out.print(ch);
                }
            }
        }
    }
    C6N38RandChar() {
        mc = new MainClass();
    }
    public static void main(String[] args) {
        C6N38RandChar c6n38 = new C6N38RandChar();
        c6n38.mc.StartIt();
    }
}
