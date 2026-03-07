import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        char[] a = (" " + br.readLine()).toCharArray();
        char[] b = (" " + br.readLine()).toCharArray();
        
        int[][] dp = new int[a.length][b.length];
        int aLength = a.length-1;
        int bLength = b.length-1;

        int maximum = 0;
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a[i] == b[j]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;

                maximum = Math.max(maximum, dp[i][j]);
            }
        }

        System.out.println(maximum);
    }
}