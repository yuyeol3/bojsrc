import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] dp = new boolean[2001][2001];
    static int[] nums = new int[2001];

    public static void main(String[] args) throws IOException {
        /*
            1. 한 글자는 무조건 펠린드롬이다
            2. [S,E]가 펠린드롬이려면, [S+1,E-1]도 펠린드롬이어야 한다.
        */

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            nums[i] = Integer.parseInt(st.nextToken());


        // 1,1 1,2 1,3 1,4 1,5 1,6 1,7
        // x    x  2,2 2,3 2,4 2,5 2,6
        // x    x  x   x   3,3 3,4 3,5
        //                 x   x   4,6
        //                         5,5
        for (int i = 1; i <= n; i++) 
            dp[i][i] = true;

        for (int i = n-1; i >= 1; i--) {
            dp[i][i+1] = (nums[i] == nums[i+1]);
            for (int j = i+2; j <= n; j++) {
                dp[i][j] = dp[i+1][j-1] && (nums[i] == nums[j]);
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s, e;

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e] ? 1 : 0).append("\n");

        }  
        System.out.print(sb);
    }
}
