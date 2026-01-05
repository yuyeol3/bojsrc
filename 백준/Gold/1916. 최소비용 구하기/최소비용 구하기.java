import java.util.*;
import java.io.*;

class State {
    public long dist;
    public int node;

    public State(long dist, int node) {
        this.node = node;
        this.dist = dist;
    }
}

class Edge {
    public int cost;
    public int node;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long INF = 100000L * 100000L + 1;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[N+5];
        for (int i = 0; i < N+5; i++)
            graph[i] = new ArrayList<>();

        StringTokenizer s;
        for (int i = 0; i < M; i++) {
            s = new StringTokenizer(br.readLine());

            int a, b, e;
            a = Integer.parseInt(s.nextToken());
            b = Integer.parseInt(s.nextToken());
            e = Integer.parseInt(s.nextToken());

            graph[a].add(new Edge(b, e));
        }

        s = new StringTokenizer(br.readLine());
        int st, ed;
        st = Integer.parseInt(s.nextToken());
        ed = Integer.parseInt(s.nextToken());

        long[] distances = new long[N+5];
        for (int i = 1; i <= N; i++) {
            distances[i] = INF;
        }
        distances[st] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.dist));
        pq.offer(new State(0, st));

        while (!pq.isEmpty()) {
            State state = pq.poll();
            if (distances[state.node] < state.dist) continue;
            if (state.node == ed) break;

            for (Edge adj : graph[state.node]) {
                long newDist = state.dist + adj.cost;
                
                if (newDist < distances[adj.node]) {
                    distances[adj.node] = newDist;
                    pq.offer(new State(newDist, adj.node));
                }
            }
        }

        bw.write(distances[ed] + "\n");
        bw.flush();
    }
}