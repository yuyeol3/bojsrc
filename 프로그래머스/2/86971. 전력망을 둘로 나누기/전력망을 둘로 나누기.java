import java.util.*;


class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int answer = 1000;
        for (int[] wire : wires) {
            int diff = Math.abs(bfs(wire[0], graph, wire) - bfs(wire[1], graph, wire));
            answer = Math.min(answer, diff);
        }

        return answer;
    }
    
    int bfs(int start, List<List<Integer>> graph, int[] disconnected) {
        int count = 0;
        boolean[] visited = new boolean[graph.size() + 1];
        Deque<Integer> q = new ArrayDeque<>();

        q.offerLast(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.pollFirst();
            count++;

            for (int adj : graph.get(node)) {
                if (visited[adj]) continue;
                if ((disconnected[0] == adj && disconnected[1] == node) || 
                    (disconnected[1] == adj && disconnected[0] == node))
                    continue;
                

                visited[adj] = true;
                q.offerLast(adj);
            }
        }

        return count;
    }
}