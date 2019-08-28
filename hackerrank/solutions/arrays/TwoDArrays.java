import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArrays {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
         int maxsum = 0;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if (y + 2 < arr[0].length && x + 2 < arr.length) {
                    int topSum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2];
                    int midSum = arr[x + 1][y + 1];
                    int botSum = arr[x + 2][y] + arr[x + 2][y + 1]
                            + arr[x + 2][y + 2];
                    int tempSum = topSum + midSum + botSum;
                    if (x == 0 && y == 0)
                        maxsum = tempSum;
                    if (tempSum > maxsum)
                        maxsum = tempSum;


                }
            }

        }
        return maxsum;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
