import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br 
        = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[N+1];

        // boolean[][] adjMat = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) 
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // if (adjMat[a][b]) continue;
            // adjMat[a][b] = adjMat[b][a] = true;
            graph[a].add(b);
            graph[b].add(a);
        }

        int minNum = 10005;
        int minUser = -1;
        Deque<Integer> q = new ArrayDeque<>();
        int[] visited = new int[N+1];
        for (int u = 1; u <= N; u++) {
            Arrays.fill(visited, -1);
            q.addLast(u);
            visited[u] = 0;
            
            int num = 0;
            while (!q.isEmpty()) {
                int cu = q.pollFirst();
                num += visited[cu];

                for (int adj : graph[cu]) {
                    if (visited[adj] != -1) continue;
                    visited[adj] = visited[cu] + 1;
                    q.addLast(adj);
                }
            }
            // System.out.println("u=" + u + "," + "visited=" + Arrays.toString(visited));
            if (num < minNum) {
                minNum = num;
                minUser = u;
            }
        }

        System.out.println(minUser);
    }
}