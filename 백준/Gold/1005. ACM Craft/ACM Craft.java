import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] costs = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            @SuppressWarnings("unchecked")
            List<Integer>[] inGraph = new List[N+1];

            @SuppressWarnings("unchecked")
            List<Integer>[] outGraph = new List[N+1];

            int[] indegree = new int[N+1];

            for (int i = 1; i <= N; i++) {
                inGraph[i] = new ArrayList<>();
                outGraph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                outGraph[a].add(b);
                inGraph[b].add(a);
                indegree[b]++;
            }

            int W = Integer.parseInt(br.readLine());
            
            boolean[] visited = new boolean[N+1];
            Deque<Integer> dq = new ArrayDeque<>();
            dq.addFirst(W);
            visited[W] = true;

            while (!dq.isEmpty()) {
                int s = dq.pollFirst();

                for (int adj : inGraph[s]) {
                    if (visited[adj]) continue;
                    visited[adj] = true;
                    dq.addFirst(adj);
                }
            }

            Deque<Integer> queue = new ArrayDeque<>();
            long[] dp = new long[N+1];
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0 && visited[i]) {
                    queue.addLast(i);
                    dp[i] = costs[i];
                }
            }

            while (!queue.isEmpty()) {
                int s = queue.pollFirst();

                for (int adj : outGraph[s]) {
                    indegree[adj]--;
                    if (indegree[adj] == 0 && visited[adj]) {
                        for (int parent : inGraph[adj]) {
                            if (!visited[parent]) continue;
                            dp[adj] = Math.max(dp[adj], dp[parent] + costs[adj]);
                        }
                        queue.addLast(adj);
                    }
                        
                }
            }

            sb.append(dp[W]).append("\n");
        }
        System.out.print(sb);
    }

}