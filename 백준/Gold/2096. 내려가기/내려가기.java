import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+5][3];
        int[][][] dp = new int[N+5][3][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0][0] = Math.min(dp[i-1][0][0], dp[i-1][1][0]) + arr[i][0];
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][1]) + arr[i][0];

            dp[i][1][0] = Math.min(Math.min(dp[i-1][0][0], dp[i-1][1][0]), dp[i-1][2][0]) +  arr[i][1];
            dp[i][1][1] = Math.max(Math.max(dp[i-1][0][1], dp[i-1][1][1]), dp[i-1][2][1]) +  arr[i][1];

            dp[i][2][0] = Math.min(dp[i-1][1][0], dp[i-1][2][0]) + arr[i][2];
            dp[i][2][1] = Math.max(dp[i-1][1][1], dp[i-1][2][1]) + arr[i][2];
        }


        int minScore, maxScore;
        minScore = Math.min(Math.min(dp[N-1][0][0], dp[N-1][1][0]), dp[N-1][2][0]);
        maxScore = Math.max(Math.max(dp[N-1][0][1], dp[N-1][1][1]), dp[N-1][2][1]);
        bw.write(String.format("%d %d\n", maxScore, minScore));
        bw.flush();
    }
}