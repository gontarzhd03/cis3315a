package chap3;

import java.util.Scanner;

/**
 * Compute the day of the week
 *
 * @author Hank Gontarz
 */
public class P03N21DayOfWeek {

    public int computeDayOfWeek(int year, int month, int day) {
        int result;

        result = (day + ((26 * (month + 1)) / 10) + (year % 100) + (year % 100) / 4 + (year / 100) / 4 + (5 * (year / 100))) % 7;
        return result;
    }

    public String getDayStr(int weekday) {
        String str1 = "";
        switch (weekday) {
            case 0:
                str1 = "Saturday";
                break;
            case 1:
                str1 = "Sunday";
                break;
            case 2:
                str1 = "Monday";
                break;
            case 3:
                str1 = "Tuesday";
                break;
            case 4:
                str1 = "Wednesday";
                break;
            case 5:
                str1 = "Thursday";
                break;
            case 6:
                str1 = "Friday";
                break;
        }
        return str1;
    }

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Compute the day of the week *****");
        System.out.print("Enter year (e.g. 2012): ");
        int year = sc.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter the day of the month (1-31): ");
        int day = sc.nextInt();
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        System.out.printf("Day of the week is %s\n", getDayStr(computeDayOfWeek(year, month, day)));
    }

    public static void main(String[] args) {
        P03N21DayOfWeek dow = new P03N21DayOfWeek();
        dow.getInput();
    }
}
