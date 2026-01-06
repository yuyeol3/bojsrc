import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+5][3];
        int[][][] dp = new int[2][3][2];
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

        int prev = 0, next = 1;
        for (int i = 1; i < N; i++) {
            dp[next][0][0] = Math.min(dp[prev][0][0], dp[prev][1][0]) + arr[i][0];
            dp[next][0][1] = Math.max(dp[prev][0][1], dp[prev][1][1]) + arr[i][0];

            dp[next][1][0] = Math.min(Math.min(dp[prev][0][0], dp[prev][1][0]), dp[prev][2][0]) +  arr[i][1];
            dp[next][1][1] = Math.max(Math.max(dp[prev][0][1], dp[prev][1][1]), dp[prev][2][1]) +  arr[i][1];

            dp[next][2][0] = Math.min(dp[prev][1][0], dp[prev][2][0]) + arr[i][2];
            dp[next][2][1] = Math.max(dp[prev][1][1], dp[prev][2][1]) + arr[i][2];

            prev = (prev + 1) % 2;
            next = (next + 1) % 2;
        }

        
        int minScore, maxScore;
        minScore = Math.min(Math.min(dp[prev][0][0], dp[prev][1][0]), dp[prev][2][0]);
        maxScore = Math.max(Math.max(dp[prev][0][1], dp[prev][1][1]), dp[prev][2][1]);
        bw.write(String.format("%d %d\n", maxScore, minScore));
        bw.flush();
    }
}