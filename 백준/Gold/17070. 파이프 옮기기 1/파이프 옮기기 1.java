import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N+5][N+5];
        int dp[][][] = new int[N+5][N+5][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        dp[i][j][k] : i, j에서 k방향으로 올 수 있는 방법의 수
        dp[i][j] = (i,j) 로 올수있는 개수들
        */
        dp[1][2][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (arr[i][j] != 0) continue;

                // if (j > 2) {
                //     dp[i][j][0] += dp[i][j-1][0];
                // }

                // if (i > 2) {
                //     dp[i][j][1] += dp[i-1][j][1];
                // }

                // if (arr[i-1][j] == 0 && arr[i][j-1] == 0 && (i > 2 || j > 2)) {
                //     dp[i][j] += dp[i-1][j-1];
                // }

                if (j > 2) {
                    dp[i][j][0] += dp[i][j-1][0]; // 가로 -> 가로

                    // 가로 -> 대각선
                    if (arr[i-1][j] == 0 && arr[i][j-1] == 0)
                        dp[i][j][2] += dp[i-1][j-1][0];
                }

                if (i > 2) {
                    dp[i][j][1] += dp[i-1][j][1];  // 세로 -> 세로

                    // 세로 -> 대각선
                    if (arr[i-1][j] == 0 && arr[i][j-1] == 0)
                        dp[i][j][2] += dp[i-1][j-1][1];
                }

                // if (i > 2 && j > 2) {
                    dp[i][j][0] += dp[i][j-1][2]; // 대각선 -> 가로
                    dp[i][j][1] += dp[i-1][j][2]; // 대각선 -> 세로

                    // 대각선 -> 대각선
                    if (arr[i-1][j] == 0 && arr[i][j-1] == 0)
                        dp[i][j][2] += dp[i-1][j-1][2];
                // }

            }
        }

        // bw.write("\n");
        // for (int i = 1; i <= N; i++) {
        //     for (int j = 1; j <= N; j++) {
        //         bw.write("(" + dp[i][j][0] + "," + dp[i][j][1] + "," + dp[i][j][2] + ") ");
        //     }
        //     bw.write("\n");
        // }
        // bw.write("\n");

        bw.write((dp[N][N][0] + dp[N][N][1] + dp[N][N][2]) + "\n");
        bw.flush();
    }
}