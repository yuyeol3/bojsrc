import java.util.*;

class Solution {
    class Node {
        public int cost, num;
        
        public Node(int cost, int num) {
            this.cost = cost;
            this.num = num;
        }
    }
    
    class Edge {
        public int cost, to;
        
        public Edge(int cost, int to) {
            this.cost = cost;
            this.to = to;
        }
    }
    
    List<List<Edge>> graph;
    final int INF = 20000001;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
            시작지점->공통지점->A,B 목적지점
        */
        // 인접리스트 형태로 그래프 생성
        graph = new ArrayList<>(n+1);
        for (int i = 0; i < n+1; i++) 
            graph.add(new ArrayList<>());
        
        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[2], fare[1]));
            graph.get(fare[1]).add(new Edge(fare[2], fare[0]));
        }
        
        int[] sDist = dijkstra(s);
        int[] aDist = dijkstra(a);
        int[] bDist = dijkstra(b);
        
        int minCost = INF;
        
        for (int i = 1; i <= n; i++) {
            int cost = sDist[i] + aDist[i] + bDist[i];
            if (cost < minCost)
                minCost = cost;
        }
        
        return minCost;
    }
    
    public int[] dijkstra(int start) {
        PriorityQueue<Node> pq = 
            new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, INF);
        
        dist[start] = 0;
        pq.offer(new Node(0, start));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.cost > dist[cur.num]) continue;
            
            for (Edge edge : graph.get(cur.num)) {
                int newCost = edge.cost + cur.cost;
                
                if (newCost < dist[edge.to]) {
                    dist[edge.to] = newCost;
                    pq.offer(new Node(newCost, edge.to));
                }
            }
        }
        
        return dist;
    }
    
    
}