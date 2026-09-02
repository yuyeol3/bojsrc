import java.util.*;

// 1. 이분탐색하고 판정
// 2. 


// 각 인원은 팀원이면서 팀장일 수 있다. 
// (선택비, 그룹비)


// (부모-17이 선택되었을 때의 비용, 부모-17이 선택되지 않았을 때 비용)
/*
    D: 17, 14
    C : 19+14, 17
    B : 28, 13
    E : 15, 0
    A : 14+13+17, 15+13+17
    
    그룹장을 선택하는 경우 -> 모두 unchosen 혹은 chosen 가능
    그룹장을 선택하지 않는 경우 -> 1개 이상의 chosen과 나머지 unchosen 
*/

class Solution {
    public int solution(int[] sales, int[][] links) {    
        int n = sales.length;
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n+1; i++) 
            graph.add(new ArrayList<>());
        
        for (int[] link : links) {
            graph.get(link[0]).add(link[1]);
        }
        // return graph;
        
        int[] result = calc(1, sales, graph);
        return Math.min(result[0], result[1]);

    }
    
    int[] calc(int node, int[] sales, List<List<Integer>> graph) {
        
        int chosen = sales[node-1];
        int unchosen = 0;
        
        if (graph.get(node).size() == 0) {
            return new int[]{chosen, unchosen};    
        }
        
        int adjSize = graph.get(node).size();
        int[][] adjResults = new int[adjSize][0]; 
        
        for (int i = 0; i < adjSize; i++)
            adjResults[i] = calc(graph.get(node).get(i), sales, graph);   
        
        // parent 노드를 선택한 경우, 나머지 노드는 모두 chosen 혹은 unchosen일 수 있다.
        for (int i = 0; i < adjSize; i++) {
            chosen += Math.min(adjResults[i][0], adjResults[i][1]);   
        }
        
        // parent 노드를 선택하지 않은 경우, 
        // 나머지 노드는 가장 작은 chosen 1개 선택, 나머지는 
        
        int tot = Arrays.stream(adjResults)
                .mapToInt((e)->Math.min(e[0], e[1]))
                .sum();
        unchosen = Integer.MAX_VALUE;
        for (int selected = 0; selected < adjSize; selected++) {
            unchosen = Math.min(
                unchosen, 
                tot - Math.min(adjResults[selected][0], adjResults[selected][1]) + adjResults[selected][0]
            );
        }
//         int minChosenIdx = 0;
//         int minChosen = Integer.MAX_VALUE;
//         for (int i = 0; i < adjSize; i++) {
//             if (adjResults[i][0] < minChosen) {
//                 minChosenIdx = i;
//                 minChosen = adjResults[i][0];
//             }
//         }
        
//         for (int i = 0; i < adjSize; i++) {
//             if (i == minChosenIdx) 
//                 unchosen += adjResults[i][0];
//             else
//                 unchosen += Math.min(adjResults[i][0], adjResults[i][1]);   
//         }
        
        return new int[]{chosen, unchosen};
    }
}