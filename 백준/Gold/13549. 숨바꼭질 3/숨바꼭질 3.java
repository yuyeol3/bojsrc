import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int INF = 100005;
    static final int[] costs = {1,1,0};
    static class State {
        public int dist;
        public int num;

        public State(int dist, int num) {
            this.dist = dist;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] distances = new int[INF];
        Arrays.fill(distances, INF);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(e->e.dist));
        distances[N] = 0;
        pq.offer(new State(0, N));

        while (!pq.isEmpty()) {
            State s = pq.poll();
            if (s.dist > distances[s.num]) continue;
            if (s.num == K) break;
            int[] adjs = {s.num-1, s.num+1, 2*s.num};
            for (int i = 0; i < 3; i++) {
                int adjNum = adjs[i];
                int adjCost = costs[i];
                if (adjNum > Math.max(K, N) + 2 || adjNum < 0) continue;

                int newDist = s.dist + adjCost;
                if (newDist < distances[adjNum]) {
                    distances[adjNum] = newDist;
                    pq.offer(new State(newDist, adjNum));
                }
            }   
        }

        bw.write(distances[K] + "\n");
        bw.flush();
    }
}