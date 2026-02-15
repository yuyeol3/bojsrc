import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] squares = new int[n+1];
        int sidx = 0;

        Arrays.fill(dp, 5);
        
        // O(\sqrt n)
        for (int i = 1; i * i <= n; i++) {
            dp[i*i] = 1;
            squares[sidx++] = i*i;
            // System.out.println(i*i);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < sidx && squares[j] <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - squares[j]]);
            }
        }

        System.out.println(dp[n]);

    }

}