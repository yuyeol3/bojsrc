import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] links = new int[N+1];
            int[] indegree = new int[N+1];
            for (int i = 1; i <= N; i++) {
                links[i] = Integer.parseInt(st.nextToken());
                indegree[links[i]]++;
            }

            Deque<Integer> q = new ArrayDeque<>();
            int noGroup = 0;
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.offerLast(i);
                    noGroup++;
                }
            }

            while (!q.isEmpty()) {
                int s = q.pollFirst();

                if (--indegree[links[s]] == 0) {
                    q.offerLast(links[s]);
                    noGroup++;
                }
            }
            sb.append(noGroup).append("\n");

        }
        System.out.print(sb);
    }
}