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
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, M;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->Integer.compare(b, a));
            Deque<Pair> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int t = Integer.parseInt(st.nextToken());
                pq.offer(t);
                dq.addLast(new Pair(t, i));
            }

            int idx = 1;
            while (!dq.isEmpty()) {
                Pair e = dq.pollFirst();
                if (pq.peek() > e.num) {
                    dq.addLast(e);
                    continue;
                }

                pq.poll();
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