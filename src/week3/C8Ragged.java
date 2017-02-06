package week3;

/**
 *
 * @author Hank Gontarz
 */
public class C8Ragged {
    public static void main(String[] args) {
        int[][] triangleArray = {{1,2,3,4,5}, {20,3,4,5}, {3,4,5}, {4,5}, {5,0}};
        System.out.println("0,0 = " + triangleArray[0][0]);
        System.out.println("0,0 = " + triangleArray[0][1]);
        System.out.println("0,0 = " + triangleArray[1][0]);
        System.out.println("0,0 = " + triangleArray[4][1]);
        triangleArray[4][1] = 41;
        int[][] ta = new int[5][];
        ta[0] = new int[5];
        ta[1] = new int[4];
        
        for(int row = 0; row < triangleArray.length; row++) {
            for(int col = 0; col < triangleArray[row].length; col++) {
                System.out.print(triangleArray[row][col] + " ");
            }
            System.out.println("");
        }
    }
}
