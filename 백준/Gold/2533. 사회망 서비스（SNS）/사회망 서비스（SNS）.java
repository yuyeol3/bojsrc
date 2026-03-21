import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        /*
            1. 정점이 하나 뿐이라면 자기 자신이 얼리어뎁터가 되어야 함
            2. 정점이 여러개라면?
                - 계층별 찾기?
        */

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        List<Integer>[] tree = new List[N+1];

        // int[] indegree = new int[N+1];

        dp = new int[N+1][2];
        for (int i = 1; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
            tree[b].add(a);
            // indegree[b]++;
        }

        // int root = 0;
        // for (int i = 1; i <= N; i++) {
        //     if (indegree[i] == 0) {
        //         dfs(i, tree);
        //         root = i;
        //         break;
        //     }
        // }
        dfs(1, 0, tree);

        // for (int i = 1; i <= N; i++) 
        //     System.out.println(i + " : " + Arrays.toString(dp[i]));

        System.out.println(Math.min(dp[1][0], dp[1][1]));
        // System.out.println(Arrays.toString(indegree));
    }

    static void dfs(int x, int parent, List<Integer>[] tree) {
        dp[x][0] = 0;
        dp[x][1] = 1;

        for (int adj : tree[x]) {
            if (adj == parent) continue;
            dfs(adj, x, tree);
            
            dp[x][0] += dp[adj][1];
            dp[x][1] += Math.min(dp[adj][0], dp[adj][1]);
        }

    }
}