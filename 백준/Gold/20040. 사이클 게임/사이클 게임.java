import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] roots;

    static void init(int n) {
        roots = new int[n+1];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        roots[rootB] = rootA;
    }

    static int find(int x) {
        if (x == roots[x]) return x;
        roots[x] = find(roots[x]);
        return roots[x];
    }

    public static void main(String[] args) throws IOException {
        // 이미 루트가 x인 애가 또 연결되면 사이클이 완성
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        init(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                System.out.println(i+1);
                return;
            }

            union(a, b);
        }
        System.out.println(0);
    }
}