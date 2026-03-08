import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int[] parents;
    static int[] ranks;
    
    static void init(int n) {
        parents = new int[n+1];
        ranks = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (ranks[rootA] < ranks[rootB]) {
            int tmp = rootA;
            rootA = rootB;
            rootB = tmp;
        }
        
        ranks[rootA] += (ranks[rootA] == ranks[rootB] ? 1 : 0);
        parents[rootB] = rootA;
        
    }
    
    
    static int find(int x) {
        if (parents[x] == x) return x;
        parents[x] = find(parents[x]);
        return parents[x];
        
    }
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        init(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            union(a, b);
        }
        
        
        boolean[] check = new boolean[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (!check[root]) {
                check[root] = true;
                count++;
            }
        }
        
        System.out.println(count);
    }

}