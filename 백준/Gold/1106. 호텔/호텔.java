import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C, N;

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] adv = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            adv[i][0] = Integer.parseInt(st.nextToken()); // cost
            adv[i][1] = Integer.parseInt(st.nextToken()); // value
        }
        /*
            dp[i] = i원을 썼을 때 얻을 수 있는 최대 고객 수 


        */

        /*
            dp 배열의 크기는 어느 정도여야 할까?
            만약 100원을 써서 1명을 늘릴 수 있고, C=1000이라면
            100 * 1000 = 100000
            배열의 크기는 최대 100000
        */
        int[] dp = new int[100005];
        int result = 100 * C + 5;
        for (int i = 0; i < 100 * C + 5; i++) {
            for (int j = 0; j < N; j++) {
                if (i - adv[j][0] < 0) continue;
                dp[i] = Math.max(dp[i], dp[i-adv[j][0]] + adv[j][1]);
            }

            if (dp[i] >= C) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
    }
}