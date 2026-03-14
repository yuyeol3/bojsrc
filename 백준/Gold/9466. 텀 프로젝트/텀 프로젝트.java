import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent = new int[100001];

    static void init(int n) {
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] links = new int[N+1];
            for (int i = 1; i <= N; i++) {
                links[i] = Integer.parseInt(st.nextToken());
            }

            int[] groups = new int[N];
            int groupCnt = 0;

            init(N);
            for (int i = 1; i <= N; i++) {
                if (find(links[i]) != find(i))
                    union(links[i], i);
                else
                    groups[groupCnt++] = links[i];
            }

            int noGroup = N - groupCnt;
            for (int i = 0; i < groupCnt; i++) {
                int sp = groups[i];   // 6
                int p = links[sp];    // 4
                while (p != sp) {
                    p = links[p];
                    noGroup--;
                }
            }
            sb.append(noGroup).append("\n");   
        }
        System.out.print(sb);
    }
}