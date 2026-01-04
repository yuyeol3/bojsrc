import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Long, Integer> visited = new HashMap<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer s = new StringTokenizer(br.readLine());
        long a = Long.parseLong(s.nextToken());
        long b = Long.parseLong(s.nextToken());

        Deque<Long> queue = new ArrayDeque<>();
        queue.addLast(a);
        visited.put(a, 0);

        while (!queue.isEmpty()) {
            long node = queue.pop();
            List<Long> adjs = List.of(node * 2, node * 10 + 1);
            for (long adj : adjs) {
                if (visited.get(adj) != null && 
                    visited.get(node) + 1 >= visited.get(adj)) 
                    continue;
                
                if (adj > b) continue;

                visited.put(adj, visited.get(node) + 1);
                queue.addLast(adj);
            }
        }

        visited.computeIfAbsent(b, k -> -2);
        bw.write((visited.get(b) + 1) + "\n");
        bw.flush();
    }
}
