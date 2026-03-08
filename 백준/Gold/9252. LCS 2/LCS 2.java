import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        char[] a = (" " + br.readLine()).toCharArray();
        char[] b = (" " + br.readLine()).toCharArray();
        int aLength = a.length-1;
        int bLength = b.length-1;

        // dp[i][j] => a의 i번째까지, b의 j번째까지 포함했을 때의 LCS
        int[][] dp = new int[aLength+1][bLength+1];
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a[i] == b[j]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        int r = aLength;
        int c = bLength;
        Deque<Character> stk = new ArrayDeque<>();

        while (r > 0 && c > 0) {
            if (a[r] == b[c]) {
                stk.offerFirst(a[r]);
                r--; c--;
            }
            else {
                if (dp[r-1][c] >= dp[r][c-1]) r--;
                else c--;
            }
        }

        // for (int i = 1; i <= aLength; i++) {
        //     for (int j = 1; j <= bLength; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        StringBuilder sb = new StringBuilder();
        sb.append(stk.size()).append("\n");
        while (!stk.isEmpty()) 
            sb.append(stk.pollFirst());
        System.out.println(sb);
    }
}