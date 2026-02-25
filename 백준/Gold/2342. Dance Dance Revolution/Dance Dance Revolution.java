import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = 400005;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> commands = new ArrayList<>();

        int num;
        while ((num = Integer.parseInt(st.nextToken())) != 0) 
            commands.add(num);

        int n = commands.size();
        int[][][] dp = new int[n+1][5][5];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        dp[0][0][0] = 0;

        // j 왼발 k 오른발
        // 왼발이 commands[i]로 이동하거나 오른발이 commands[i]로 이동해야 함
        // dp[i][j][commands[i]] = min(dp[i-1][j][?] + cost)
        // dp[i][commands[i]][k] = min(dp[i-1][?][k] + cost)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    int command = commands.get(i-1);
                    if (j == command) continue; // 두 발은 같은 곳에 있을 수 없음

                    // k -> commands[i] 로 가는 비용
                    int cost = calcCost(k, command);

                    dp[i][j][command] = 
                        Math.min(dp[i][j][command], dp[i-1][j][k] + cost);


                    dp[i][command][j] =
                        Math.min(dp[i][command][j], dp[i-1][k][j] + cost);
                }
            }
        }

        int minimum = INF;
        for (int i = 0; i <= 4; i++)  {
            minimum = Math.min(minimum, dp[n][i][commands.get(n-1)]);
            minimum = Math.min(minimum, dp[n][commands.get(n-1)][i]);
        }

        System.out.println(minimum);

    }

    static final int[] dir = {1,2,3,4};
    static int calcCost(int prev, int cur) {
        if (prev == 0) return 2;
        if (dir[(4 + (prev-1) - 1) % 4] == cur ||
            dir[(prev)%4] == cur
        ) return 3;

        if (dir[(4 + (prev-1) - 2) % 4] == cur ||
            dir[((prev-1)+2)%4] == cur
           ) return 4;

        return 1;
    }

}