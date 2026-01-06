import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[2][3][2];
        StringTokenizer st;
        // for (int i = 0; i < N; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     for (int j = 0; j < 3; j++) {
        //         arr[i][j] = Integer.parseInt(st.nextToken());
        //     }
        // }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int e = Integer.parseInt(st.nextToken());
            dp[0][i][0] = e;
            dp[0][i][1] = e;
        }

        int prev = 0, next = 1;
        for (int i = 1; i < N; i++) {
            int one, two, three;
            st = new StringTokenizer(br.readLine());
            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());
            three = Integer.parseInt(st.nextToken());
            dp[next][0][0] = Math.min(dp[prev][0][0], dp[prev][1][0]) + one;
            dp[next][0][1] = Math.max(dp[prev][0][1], dp[prev][1][1]) + one;

            dp[next][1][0] = Math.min(Math.min(dp[prev][0][0], dp[prev][1][0]), dp[prev][2][0]) + two;
            dp[next][1][1] = Math.max(Math.max(dp[prev][0][1], dp[prev][1][1]), dp[prev][2][1]) + two;

            dp[next][2][0] = Math.min(dp[prev][1][0], dp[prev][2][0]) + three;
            dp[next][2][1] = Math.max(dp[prev][1][1], dp[prev][2][1]) + three;

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