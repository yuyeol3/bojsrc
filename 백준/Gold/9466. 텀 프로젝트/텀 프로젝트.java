import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited;
    static int[] links;
    static int groupCount;

    static void dfs(int x) {
        visited[x] = 1;
        int next = links[x];
        if (visited[next] == 0) {
            dfs(next);
        }
        else if (visited[next] == 1) {
            groupCount++;
            for (int p = links[next]; p != next; p = links[p])
                groupCount++;
            
        }

        visited[x] = 2;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            links = new int[N+1];
            for (int i = 1; i <= N; i++) {
                links[i] = Integer.parseInt(st.nextToken());
            }

            groupCount = 0;
            visited = new int[N+1];
            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) dfs(i);
            }

            sb.append(N-groupCount).append("\n");

        }
        System.out.print(sb);
    }
}