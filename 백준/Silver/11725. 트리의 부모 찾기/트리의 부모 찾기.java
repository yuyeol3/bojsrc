import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parents;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tree = new ArrayList[N+5];
        
        parents = new int[N+5];

        for (int i = 1; i <= N; i++) 
            tree[i] = new ArrayList<>();


        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        Stack<Integer> s = new Stack<>();
        s.push(1);
        parents[1] = -1;

        while (!s.empty()) {
            int parent = s.pop();
            List<Integer> adjs = tree[parent];
            if (adjs == null) continue;
            for (int adj : adjs) {
                if (parents[adj] != 0) continue;
                parents[adj] = parent;
                s.push(adj);
            }
        }

        for (int i = 2; i <= N; i++) {
            bw.write(parents[i] + "\n");
        }


        bw.flush();
        bw.close();
    }
}