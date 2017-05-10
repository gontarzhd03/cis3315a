package chap3;

import java.util.Random;

/**
 * Output a random month string
 *
 * @author Hank Gontarz
 */
public class P03N04RandomMonth {
    public void getRandomMonth() {
        String str1 = "";
        Random rand = new Random();
        int month = rand.nextInt(12) + 1;
        switch (month) {
            case 1:
                str1 = "January";
                break;
            case 2:
                str1 = "February";
                break;
            case 3:
                str1 = "March";
                break;
            case 4:
                str1 = "April";
                break;
            case 5:
                str1 = "May";
                break;
            case 6:
                str1 = "June";
                break;
            case 7:
                str1 = "July";
                break;
            case 8:
                str1 = "August";
                break;
            case 9:
                str1 = "September";
                break;
            case 10:
                str1 = "October";
                break;
            case 11:
                str1 = "November";
                break;
            case 12:
                str1 = "December";
                break;
        }
        System.out.printf("The month is: %s\n", str1);
    }
    public static void main(String[] args) {
        P03N04RandomMonth month = new P03N04RandomMonth();
        month.getRandomMonth();
    }
}
