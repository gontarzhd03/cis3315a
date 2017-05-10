package chap6;

/**
 *
 * @author Hank Gontarz
 */
public class C6N37Format {
    public static String format(int number, int width) {
        String rc;
        String fmt;
        
        fmt = "%0" + String.format("%d", width) + "d";
        rc = String.format(fmt, number);
        return rc;
    }
    public static String format2(int number, int width) {
        String rc = "";
        String txt;
        
        txt = String.format("%d", number);
        if(width - txt.length() > 0) {
            int prefix = width - txt.length();
            for(int i = 0; i < prefix; i++) {
                rc += "0";
            }
        }
        rc += txt;
        return rc;
    }
    public static void main(String[] args) {
        System.out.println(format(34, 1));
        System.out.println(format(34, 4));
        System.out.println(format(34, 5));
        
        System.out.println(format2(34, 1));
        System.out.println(format2(34, 4));
        System.out.println(format2(34, 5));
    }
}
