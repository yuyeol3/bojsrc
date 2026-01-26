import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[N+1]; // 나가는 방향 그래프
        int[] indegree = new int[N+1];  // 들어오는 방향 그래프

        for (int i = 1; i <= N; i++) 
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;   
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == b) continue;

            graph[a].add(b);
            indegree[b]++;
        }


        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                queue.addLast(i);
        }

        // System.out.println(ltStack);
        int[] sorted = new int[N+1];
        int idx = 0;
        while (!queue.isEmpty()) {
            int s = queue.pollFirst();
            sorted[idx++] = s;

            for (int adj : graph[s]) {
                indegree[adj]--;
                if (indegree[adj] == 0)
                    queue.addLast(adj);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(sorted[i]).append(" ");
        }
        System.out.println(sb);
    }
}