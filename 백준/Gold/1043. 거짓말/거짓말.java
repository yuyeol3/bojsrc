import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    static int[] rank;
    static void initialize(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rank[rootB] > rank[rootA]) {
            int tmp = rootA;
            rootA = rootB;
            rootB = tmp;
        }

        // if (rootA != rootB) 
        parent[rootB] = rootA;

        if (rank[rootA] == rank[rootB])
            rank[rootA] += 1;
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
            System.out.println(M);
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


        int result = 0;
        int truthRoot = find(knowsTruth);
        for (int crit : partyCrits) {
            if (find(crit) != truthRoot) 
                result++;
        }

        System.out.println(result);
    }    
}