import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> pmap = new HashMap<>();
        
        for (String p : participant) {
            pmap.computeIfPresent(p, (k, v)->v+1);
            pmap.computeIfAbsent(p, (k)->1);
        }
        
        for (String c : completion) {
            pmap.computeIfPresent(c, (k,v)->v-1);
        }
        
        String answer = "";
        for (String k : pmap.keySet()) {
            if (pmap.get(k) != 0) {
                answer = k;
                break;
            }
        }
        // IO.println(pmap);
        return answer;
    }
    
}