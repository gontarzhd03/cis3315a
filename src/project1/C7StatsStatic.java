package project1;

/**
 * Various static helper methods.
 * @author Hank Gontarz
 */
public class C7StatsStatic {

    /**
     * Compute the square root using the Newton method. (simple)
     * @param num input to square root
     * @return double
     */
    public static double sqrt(double num) {
        double rc;
        double guess;
        
        if(num < 0) {
            num = -num;
        }
        rc = num / 2;
        do {
            guess = rc;
            rc = (guess + (num / guess)) / 2;
        } while((guess - rc) != 0);
        return rc;
    }

    /**
     * Compute the square root using the Newton method. (complex)
     * @param num input to square root
     * @return double
     */
    public static double sqrtN(double num) {
        double rc;
        double guess;
        
        if(num < 0) {
            num = -num;
        }
        rc = num / 2;
        do {
            guess = rc;
            rc = guess - ((guess * guess - num) / (2 * guess));
        } while((guess - rc) != 0);
        return rc;
    }
    
    /**
     * Compute the sum of all elements in an array of integers.
     * @param nums input array of integers
     * @return int
     */
    public static int sum(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return total;
    }
    
    /**
     * Find the smallest value in an array of integers.
     * @param x input array of integers
     * @return int
     */
    public static int min(int[] x) {
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < x.length; i++) {
            if(x[i] < smallest) {
                smallest = x[i];
            }
        }
        return smallest;
    }
    
    /**
     * Find the largest value in an array of integers.
     * @param x input array of integers
     * @return int
     */
    public static int max(int[] x) {
        int largest = 0;
        for(int i = 0; i < x.length; i++) {
            if(x[i] > largest) {
                largest = x[i];
            }
        }
        return largest;
    }
    
    /**
     * Compute the average of all elements in an array of integers.
     * @param x input array of integers
     * @return int
     */
    public static int avg(int[] x) {
        int average = 0;
        
        if(x.length > 0) {
            for(int i = 0; i < x.length; i++) {
                average += x[i];
            }
            average /= x.length;
        }
        return average;
    }
    
    /**
     * Compute the average of all elements in an array of doubles.
     * @param x input array of doubles
     * @return double
     */
    public static double avg(double[] x) {
        double average = 0;
        
        if(x.length > 0) {
            for(int i = 0; i < x.length; i++) {
                average += x[i];
            }
            average /= x.length;
        }
        return average;
    }
    
    /**
     * Compute the standard deviation of all elements in an array of integers.
     * <b>Warning!</b> Decimal precision will be lost!
     * @param x input array of integers
     * @return double
     */
    public static double stddev(int[] x) {
        double sums = 0.0;
        double dev = 0.0;
        
        if(x.length > 1) {
            int mean = avg(x);
            for(int i = 0; i < x.length; i++) {
                sums += ((x[i] - mean) * (x[i] - mean));
            }
            dev = sqrt(sums / (x.length - 1));
        }
        return dev;
    }
    
    /**
     * Compute the standard deviation of all elements in an array of doubles.
     * @param x input array of doubles
     * @return double
     */
    public static double stddev(double[] x) {
        double sums = 0.0;
        double dev = 0.0;
        
        if(x.length > 1) {
            double mean = avg(x);
            for(int i = 0; i < x.length; i++) {
                sums += ((x[i] - mean) * (x[i] - mean));
            }
            dev = sqrt(sums / (x.length - 1));
        }
        return dev;
    }

    /**
     * Reverse the order of an array of integers.
     * <b>Warning!</b> The input array will be modified!
     * @param x input array of integers
     */
    public static void reverseMutable(int[] x) {
        int tmp = 0;
        
        for(int i = 0; i < x.length/2; i++) {
            tmp = x[i];
            x[i] = x[x.length - (i + 1)];
            x[x.length - (i + 1)] = tmp;
        }
    }
    
    /**
     * Reverse the order of an array of integers and return a new array.
     * @param x input array of integers
     * @return int[]
     */
    public static int[] reverse(int[] x) {
        int[] tmp = new int[x.length];
        for(int i = x.length - 1, j = 0; i >= 0; i--, j++) {
            tmp[j] = x[i];
        }
        return tmp;
    }

    /**
     * Count the number of elements whose values are above average.
     * @param x input array of integers
     * @return int
     */
    public static int aboveAvg(int[] x) {
        int above = 0;
        
        int avg = avg(x);
        for(int i = 0; i < x.length; i++) {
            if(x[i] >= avg) {
                above++;
            }
        }
        return above;
    }

    /**
     * Count the distinct values in an array of integers.
     * Return an array containing the counts. (Maximum 101)
     * @param x input array of integers
     * @return int[]
     */
    public static int[] count100(int[] x) {
        int[] count = new int[101];
        for(int i = 0; i < x.length; i++) {
            count[x[i]]++;
        }
        return count;
    }

    /**
     * Return a new array containing only the distinct values from the input array.
     * @param x input array of integers
     * @return int[]
     */
    public static int[] distinct(int[] x) {
        int[] xx = new int[x.length];
        for(int i = 0; i < x.length; i++) {
            for(int j = 0; j < xx.length; j++) {
                if(xx[j] == x[i] || xx[j] == 0) {
                    xx[j] = x[i];
                    break;
                }
            }
        }
        return xx;
    }

    /**
     * Convert an array of integers into a comma separated string.
     * @param x input array of integers
     * @return String
     */
    public static String toString(int[] x) {
        int i = 0;
        
        StringBuilder sb = new StringBuilder();
        if(x.length > 0) {
            for(i = 0; i < x.length - 1; i++) {
                sb.append(x[i]).append(", ");
            }
            sb.append(x[i]);
        }
        return sb.toString();
    }
}

