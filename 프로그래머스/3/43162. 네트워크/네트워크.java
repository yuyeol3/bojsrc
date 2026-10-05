import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (computers[i][j] == 1)
                    graph.get(i).add(j);
            }
        }
        // return graph;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) answer++;
            else continue;
            
            visited[i] = true;
            dfs(i, graph);
        }
        
        return answer;
    }
    
    void dfs(int node, List<List<Integer>> graph) {
        // if (visited[node]) return;
        
        for (int next : graph.get(node)) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next, graph);
        }
    }
}