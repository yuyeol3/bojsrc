import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        
        Map<String, Integer> cMap = new HashMap<>();
        
        for (String[] c : clothes) {
            cMap.put(c[1], cMap.getOrDefault(c[1], 0)+1);
        }
        
        int answer = 1;
        
        for (int v : cMap.values()) {
            answer *= (v+1);
        }
        answer--;
        // IO.println(cMap.values());
        
        return answer;
    }
}