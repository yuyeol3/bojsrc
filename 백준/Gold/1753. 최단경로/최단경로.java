import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long INF = 3000005L;

    static class Edge {
        public int to;
        public int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        public int node;
        public long dist;

        public State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        long[] dist = new long[V+5];
        Arrays.fill(dist, INF);
        
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new List[E+5];
        for (int i = 0; i < E+5; i++)
            graph[i] = new ArrayList<>();


        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
        }

        PriorityQueue<State> pq 
            = new PriorityQueue<>(Comparator.comparingLong(e->e.dist));

        pq.offer(new State(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            State s = pq.poll();
            if (s.dist > dist[s.node]) continue;

            for (Edge adj : graph[s.node]) {
                if (s.dist + adj.weight < dist[adj.to]) {
                    dist[adj.to] = s.dist + adj.weight;
                    pq.offer(new State(adj.to, dist[adj.to]));
                }
            }
        }
        
        for (int i = 1; i <= V; i++) {
            bw.write((dist[i] == INF ? "INF" : dist[i]) + "\n");
        }
        bw.flush();

    }
}