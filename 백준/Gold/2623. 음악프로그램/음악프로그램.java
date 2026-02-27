import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[N+1];
        int[] indegree = new int[N+1];
        
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int[] nums = new int[L];
            
            for (int j = 0; j < L; j++) 
                nums[j] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < L-1; j++) {
                indegree[nums[j]] += j == 0 ? 0 : 1;
                graph[nums[j]].add(nums[j+1]);
            }
            indegree[nums[L-1]] += 1;
        }

        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.offerLast(i);
        }

        while (!q.isEmpty()) {
            int s = q.pollFirst();
            sorted.add(s);

            for (int adj : graph[s]) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offerLast(adj);
                }
            }
        }

        if (sorted.size() != N) {
            System.out.println(0);
        }
        else {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                sb.append(sorted.get(i)).append("\n");
            }
            System.out.println(sb);
        }

    }
}