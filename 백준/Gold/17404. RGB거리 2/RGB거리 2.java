import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = 1000005;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N+1][3];

        // level,first,cur
        int[][][] dp = new int[N+1][3][3];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i][0], INF);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], INF);
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0][0] = costs[1][0];
        dp[1][1][1] = costs[1][1];
        dp[1][2][2] = costs[1][2];

        // O(9N)
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Math.min(dp[i-1][j][(k+1)%3], dp[i-1][j][(k+2)%3]) + costs[i][k];
                }
            }
        }


        int minimum = INF;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j) continue;
                minimum = Math.min(minimum, dp[N][i][j]);
            }
        }

        System.out.println(minimum);

    }

    
}