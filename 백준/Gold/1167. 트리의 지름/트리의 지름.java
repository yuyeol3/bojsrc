import java.util.*;
import java.io.*;

class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int x;
        long y;

        public Pair(int x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        List<Pair>[] tree = new List[N+1];

        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int linkedNode, weight;
            while (true) {
                linkedNode = Integer.parseInt(st.nextToken());
                if (linkedNode == -1) break;
                weight = Integer.parseInt(st.nextToken());
                tree[node].add(new Pair(linkedNode, weight));
            }

        }


        Deque<Pair> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        Pair U = new Pair(0, 0);

        dq.addFirst(new Pair(1, 0));
        visited[1] = true;

        while (!dq.isEmpty()) {
            Pair s = dq.pollFirst();

            if (s.y > U.y) U = s;

            for (Pair adj : tree[s.x]) {
                if (visited[adj.x]) continue;
                visited[adj.x] = true;
                dq.addFirst(new Pair(adj.x, s.y + adj.y));
            }
        }

        Arrays.fill(visited, false);
        dq.addFirst(new Pair(U.x, 0));
        visited[U.x] = true;
        long diameter = 0;
        while (!dq.isEmpty()) {
            Pair s = dq.pollFirst();

            if (s.y > diameter) diameter = s.y;

            for (Pair adj : tree[s.x]) {
                if (visited[adj.x]) continue;
                visited[adj.x] = true;
                dq.addFirst(new Pair(adj.x, s.y + adj.y));
            }
        }

        System.out.println(diameter);
    }
}