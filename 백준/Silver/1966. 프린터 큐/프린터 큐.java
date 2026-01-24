import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int num;
        int idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // O(TN^2)
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, M;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            int[] priorities = new int[11];
            Deque<Pair> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            // O(N)
            int pIdx = 0;
            for (int i = 0; i < N; i++) {
                int t = Integer.parseInt(st.nextToken());
                priorities[t]++;
                if (t > pIdx) pIdx = t;
                dq.addLast(new Pair(t, i));
            }

            // O(N^2)
            int idx = 1;

            while (!dq.isEmpty()) {
                Pair e = dq.pollFirst();
                if (pIdx > e.num) {
                    dq.addLast(e);
                    continue;
                }

                priorities[pIdx]--;
                while (priorities[pIdx] == 0 && pIdx > 0)
                    pIdx--;

                if (e.idx == M) {
                    sb.append(idx).append("\n");
                    break;
                }
                idx++;
            }
        }
        System.out.print(sb);
    }
}