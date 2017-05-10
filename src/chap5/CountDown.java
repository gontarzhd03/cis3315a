package chap5;

/**
 * Count down from 10 to 0
 * @author Hank Gontarz
 */
public class CountDown {
    public static void main(String[] args) {
        int sum = 0;
        
        for(int i = 10; i >= 0; i--) {
            sum += i;
            System.out.println("Count is: " + i);
        }
        System.out.println("The sum is: " + sum);
        
        int cnt = 10;
        while(cnt >= 0) {
            System.out.println("Count is: " + cnt);
            cnt--;
        }
    }
}
