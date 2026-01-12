import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;

    static void initialize(int n) {
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) 
            parent[rootB] = rootA;
    }

    static boolean isEquivalent(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initialize(N);


        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        if (K == 0) {
            bw.write(M + "\n");
            bw.flush();
            return;
        }

        // O(K)
        int knowsTruth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K-1; i++)
            union(knowsTruth, Integer.parseInt(st.nextToken()));
        
        
        // O(M)
        int[] partyCrits = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            partyCrits[i] = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < partyNum-1; j++) {
                int participantNum = Integer.parseInt(st.nextToken());
                union(partyCrits[i], participantNum);
            }
        }

        // int result = 0;
        // for (int crit : partyCrits) {

        // }
        
        // for (int truth : knowsTruth) {
        //     union(knowsTruth[0], truth);
        // }

        // // 각 동치류가 어떻게 되어있는지 보자
        // for (int i = 1; i <= N; i++) {
        //     bw.write("i=" + i + "->" + find(i) + "\n");
        // }

        int result = 0;
        int truthRoot = find(knowsTruth);
        for (int crit : partyCrits) {
            if (find(crit) != truthRoot) 
                result++;
        }

        bw.write(result + "\n");
        bw.flush();
    }    
}