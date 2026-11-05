import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeCounts = new HashMap<>();
        for (int t : tangerine) {
            sizeCounts.put(t, sizeCounts.getOrDefault(t, 0)+1);
        }
        
        List<Integer> sortedTangerine = sizeCounts.keySet()
            .stream()
            .sorted((a, b)->Integer.compare(sizeCounts.get(a), sizeCounts.get(b)))
            .toList();
        
        int totalNum = tangerine.length;
        int answer = sizeCounts.keySet().size();
        for (int t : sortedTangerine) {
            totalNum -= sizeCounts.get(t);
            if (totalNum < k) break;
            answer--;
        }
            
        return answer;
    }
}