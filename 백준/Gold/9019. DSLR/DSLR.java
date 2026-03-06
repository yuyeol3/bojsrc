import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] names = {'D', 'S', 'L', 'R'};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] visited = new int[10000];
            int[] prev = new int[10000];

            Arrays.fill(visited, -1);
            Arrays.fill(prev, -1);

            Deque<Integer> q = new ArrayDeque<>();
            q.offerLast(a);
            visited[a] = 5;
            prev[a] = a;

            while (!q.isEmpty()) {
                int s = q.pollFirst();

                if (s == b)
                    break;

                for (int i = 0; i < 4; i++) {

                    int ns = s;
                    switch (i) {
                        case 0 : ns = (2*s)%10000; break;
                        case 1 : ns = (10000+s-1)%10000; break;
                        case 2 : ns = (s%1000)*10 + (s/1000); break;
                        case 3 : ns = (s/10) + (s % 10) * 1000; break;
                    }   

                    if (visited[ns] != -1) continue;
                    visited[ns] = i;
                    prev[ns] = s;
                    q.offerLast(ns);
                }
            }

            int s = b;
            Deque<Integer> stk = new ArrayDeque<>();
            while (prev[s] != s) {
                stk.offerFirst(visited[s]);
                s = prev[s];
            }

            while (!stk.isEmpty()) {
                sb.append(names[stk.pollFirst()]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}