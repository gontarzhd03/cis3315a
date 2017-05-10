package chap7;

/**
 *
 * @author 55gontarhd03
 */
public class C7StatsStaticTest {
    public static void main(String[] args) {
        int[] x = {5, 10, 25, 35, 50, 66, 77};
        double[] y = {1.9, 2.5, 3.7, 2.0, 1.0, 6.0, 3.0, 4.0, 5.0, 2.0};
        int[] z = {2, 5, 6, 5, 4, 3, 23, 43, 2};
        int[] q = {1, 2, 3, 2, 1, 6, 3, 4, 5, 2};
        
        System.out.println("The sum is: " + C7StatsStatic.sum(x));
        System.out.println("The minimum is: " + C7StatsStatic.min(x));
        System.out.println("The deviation is: " + C7StatsStatic.stddev(y));
        System.out.println("Sqrt1: " + Math.sqrt(5.0));
        System.out.println("Sqrt2: " + C7StatsStatic.sqrt(5.0));
        System.out.println("Sqrt1: " + C7StatsStatic.sqrtN(5.0));
        System.out.println(C7StatsStatic.toString(C7StatsStatic.reverse(x)));
        System.out.printf("Avg: %d Above: %d\n", C7StatsStatic.avg(x), C7StatsStatic.aboveAvg(x));
        int[] zz = C7StatsStatic.count100(z);
        for(int i = 0; i < z.length; i++) {
            if(zz[i] > 1) {
                System.out.printf("%d occurs %d times\n", z[i], zz[i]);
            }
            else {
                System.out.printf("%d occurs %d time\n", z[i], zz[i]);
            }
        }
        
        int[] qq = C7StatsStatic.distinct(q);
        System.out.print("The distinct numbers are: ");
        for(int i = 0; i < qq.length; i++) {
            if(qq[i] == 0) break;
            System.out.printf("%d ", qq[i]);
        }
        System.out.println("");
    }
}
