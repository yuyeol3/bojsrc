import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[] costs = {1,1,0};
    static final int INF = 100005;
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

        if (N == K) {
            bw.write(0 + "\n");
            bw.flush();
            return;
        }
        else if (N > K) {
            bw.write(N - K + "\n");
            bw.flush();
            return;
        }

        int[] distances = new int[Math.max(N, K)+5];
        Arrays.fill(distances, INF);
        Deque<State> q = new ArrayDeque<>();
        q.addLast(new State(0, N));
        distances[N] = 0;

        int result = 0;
        while (!q.isEmpty()) {
            State s = q.pop();
            if (s.dist > distances[s.num]) continue;
            if (s.num == K) {
                result = s.dist;
                break;
            }
            int[] adjs = {s.num+1, s.num-1, 2*s.num};
            for (int i = 0; i < 3; i++) {
                int adjNum = adjs[i];
                int adjCost = costs[i];
                if (adjNum > Math.max(K, N) + 2 || adjNum < 0) continue;
                
                if (s.dist + adjCost < distances[adjNum]) {
                    distances[adjNum] = s.dist + adjCost;
                    if (adjCost == 1) 
                        q.addLast(new State(s.dist + 1, adjNum));
                    else
                        q.addFirst(new State(s.dist, adjNum));
                }
                
            }   
        }

        bw.write(result + "\n");
        bw.flush();
    }
}