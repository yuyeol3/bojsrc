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
        int[][] prev = new int[5][5];
        int[][] next = new int[5][5];
        int[][] tmp;



        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                prev[i][j] = INF;
                next[i][j] = INF;
            }
        }
    
        prev[0][0] = 0;

        // j 왼발 k 오른발
        // 왼발이 commands[i]로 이동하거나 오른발이 commands[i]로 이동해야 함
        // dp[i][j][commands[i]] = min(dp[i-1][j][?] + cost)
        // dp[i][commands[i]][k] = min(dp[i-1][?][k] + cost)
        // O(16N)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    int command = commands.get(i-1);
                    if (j == command) continue; // 두 발은 같은 곳에 있을 수 없음

                    // k -> commands[i] 로 가는 비용
                    int cost = calcCost(k, command);

                    if (prev[j][k] != INF)
                        next[j][command] = 
                            Math.min(next[j][command], prev[j][k] + cost);


                    if (prev[k][j] != INF)
                        next[command][j] =
                            Math.min(next[command][j], prev[k][j] + cost);
                }    
            }

            tmp = prev;
            prev = next;
            next = tmp;

            for (int j = 0; j <= 4; j++) {
                Arrays.fill(next[j], INF);
            }
        }

        int minimum = INF;
        for (int i = 0; i <= 4; i++)  {
            minimum = Math.min(minimum, prev[i][commands.get(n-1)]);
            minimum = Math.min(minimum, prev[commands.get(n-1)][i]);
        }

        System.out.println(minimum);

    }

    static int calcCost(int prev, int cur) {
        if (prev == 0) return 2;
        int diff = Math.abs(cur-prev);

        if (diff == 0) return 1;
        if (diff == 2) return 4;        
        return 3;
    }

}