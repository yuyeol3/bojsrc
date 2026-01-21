import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cached;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, R, Q;
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cached = new int[N+1];
        visited = new boolean[N+1];

        @SuppressWarnings("unchecked")
        List<Integer>[] tree = new List[N+1];

        for (int i = 0; i <= N; i++) 
            tree[i] = new ArrayList<>();


        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(R, tree);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(cached[q]).append("\n");
        }
        System.out.print(sb);
    }

    public static int dfs(int node, final List<Integer>[] tree) {
        if (visited[node]) return 0;
        visited[node] = true;
        
        int tot = 1;
        for (int adj : tree[node]) {
            tot += dfs(adj, tree);
        }
        cached[node] = tot;
        return tot;
    }
}