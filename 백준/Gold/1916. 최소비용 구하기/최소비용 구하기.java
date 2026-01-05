import java.util.*;
import java.io.*;

class Node {
    public long dist;
    public int num;

    public Node(long dist, int num) {
        this.num = num;
        this.dist = dist;
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
        List<Node>[] graph = new ArrayList[N+5];
        for (int i = 0; i < N+5; i++)
            graph[i] = new ArrayList<>();

        StringTokenizer s;
        for (int i = 0; i < M; i++) {
            s = new StringTokenizer(br.readLine());

            int a, b, e;
            a = Integer.parseInt(s.nextToken());
            b = Integer.parseInt(s.nextToken());
            e = Integer.parseInt(s.nextToken());

            graph[a].add(new Node(e, b));
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

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.dist));
        pq.offer(new Node(0, st));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (distances[node.num] < node.dist) continue;

            for (Node adj : graph[node.num]) {
                long newDist = node.dist + adj.dist;
                
                if (newDist < distances[adj.num]) {
                    distances[adj.num] = newDist;
                    pq.offer(new Node(newDist, adj.num));
                }
            }
        }

        bw.write(distances[ed] + "\n");
        bw.flush();
    }
}