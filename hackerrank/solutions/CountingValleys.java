import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int countDownHill = 0, countUpHill = 0, valleyCount = 0;
        String firstStepFromSeaLevel = s.charAt(0)+"";
        for(int i=0;i<n;i++){
            String currentStep = s.charAt(i)+"";
            if(currentStep.equalsIgnoreCase("U")) countUpHill++;
            else if(currentStep.equalsIgnoreCase("D")) countDownHill++;
            if(countUpHill==countDownHill){
                if(firstStepFromSeaLevel.equalsIgnoreCase("D"))valleyCount++;
                countUpHill=0;
                countDownHill=0;
                if(i<n-1)firstStepFromSeaLevel = s.charAt(i+1)+"";
            }
            
        }
        return valleyCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
