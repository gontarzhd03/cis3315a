package chap5;

/**
 * Sum # from 2 - 2000
 * @author Hank Gontarz
 */
public class SumEvens {
    public static void main(String[] args) {
        int sum = 0;
        
        for(int i = 2; i <= 2000; i += 2) {
            sum += i;
        }
        System.out.println("The sum is: " + sum);
    }
}
