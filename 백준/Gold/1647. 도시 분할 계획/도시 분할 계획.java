import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int x; long y;
        public Pair(int x, long y) {this.x = x; this.y = y;}
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Pair>[] graph = new List[N+1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a, b, w;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[a].add(new Pair(b, w));
            graph[b].add(new Pair(a, w));
        }

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.y, b.y));
        pq.offer(new Pair(1, 0));
        long mstWeight = 0;
        long maxWeight = 0;

        while (!pq.isEmpty()) {
            Pair s = pq.poll();
            if (visited[s.x]) continue;
            mstWeight += s.y;
            if (s.y > maxWeight) maxWeight = s.y;
            visited[s.x] = true;
            
            for (Pair adj : graph[s.x]) {
                if (visited[adj.x]) continue;
                pq.offer(adj);
            }
        }

        System.out.println(mstWeight-maxWeight);
    }
}