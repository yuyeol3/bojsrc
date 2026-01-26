import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        Set<Integer>[] ltGraph = new Set[N+1];

        @SuppressWarnings("unchecked")
        Set<Integer>[] gtGraph = new Set[N+1];

        
        for (int i = 1; i <= N; i++) {
            ltGraph[i] = new HashSet<>();
            gtGraph[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;   
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == b) continue;

            gtGraph[b].add(a); // 더 큰 쪽으로 가는 간선
            ltGraph[a].add(b); // 더 작은 쪽으로 가는 간선
        }


        Deque<Integer> ltStack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (gtGraph[i].size() == 0)
                ltStack.addLast(i);
        }

        // System.out.println(ltStack);
        int[] sorted = new int[N+1];
        int idx = 0;
        while (!ltStack.isEmpty()) {
            int s = ltStack.pollFirst();
            sorted[idx++] = s;

            for (int adj : ltGraph[s]) {
                gtGraph[adj].remove(s);
                if (gtGraph[adj].size() == 0)
                    ltStack.addFirst(adj);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(sorted[i]).append(" ");
        }
        System.out.println(sb);
    }
}