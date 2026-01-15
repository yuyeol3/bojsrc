import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static StringBuilder sb = new StringBuilder();

    static class Pair<T1, T2> {
        public T1 x;
        public T2 y;

        public Pair(T1 x, T2 y) {
            this.x = x;
            this.y = y;
        }
    }

    static final long INF = Long.MAX_VALUE / 4;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, E;
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Pair<Integer, Integer>>[] graph = new List[N+1];

        for (int i = 0; i <= N; i++) 
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from, to, weight;

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Pair<Integer, Integer>(to, weight));
            graph[to].add(new Pair<Integer, Integer>(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int u, v;
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        long dist1[] = new long[N+1];
        dijkstra(1, dist1, graph);

        long distUV[] = new long[N+1];
        dijkstra(u, distUV, graph);

        long distN[] = new long[N+1];
        dijkstra(N, distN, graph);

        /*
        
        1 ... U ... V ... N
        1 ... V ... U ... N

        */

        long result = Math.min(
            dist1[u] + distUV[v] + distN[v],
            dist1[v] + distUV[v] + distN[u]
        );

        System.out.println((result >= INF ? -1 : result));
    }

    public static void dijkstra(int st, long[] dist, final List<Pair<Integer, Integer>>[] graph) {
        Arrays.fill(dist, INF);
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>(Comparator.comparingLong(e->e.y));

        pq.offer(new Pair<Integer, Long>(st, 0L));
        dist[st] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Long> s = pq.poll();

            if (s.y > dist[s.x]) continue;

            for (Pair<Integer, Integer> adj : graph[s.x]) {
                if (s.y + adj.y < dist[adj.x]) {
                    dist[adj.x] = s.y + adj.y;
                    pq.offer(new Pair<Integer, Long>(adj.x, dist[adj.x]));
                }
            }
        }

    }
} 