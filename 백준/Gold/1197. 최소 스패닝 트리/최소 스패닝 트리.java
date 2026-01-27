import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int x;
        long y;

        public Pair(int x, long y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "<" + x + ", " + y + ">";
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Pair>[] graph = new List[V+1];

        for (int i = 1; i <= V; i++) 
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a, b, w;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[a].add(new Pair(b, w));
            graph[b].add(new Pair(a, w));
        }

        // for (int i = 1; i <= V; i++)
        //     System.out.println(i + ": " + graph[i]);

        boolean[] visited = new boolean[V+1];
        long[] dist = new long[V+1];
        long minWeight = 0;
        int loopCnt = V-1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Long.compare(a.y, b.y));
        pq.offer(new Pair(1, 0));
        // visited[1] = true;


        while (loopCnt>=0) {
            // System.out.println(pq + "," + pq.peek().y + " added");
            Pair s = pq.poll();
            if (visited[s.x]) continue;
            visited[s.x] = true;
            minWeight += s.y;
            loopCnt--;

            for (Pair adj : graph[s.x]) {
                if (visited[adj.x]) continue;
                pq.offer(adj);
            }
        }
        System.out.println(minWeight);
    }
}