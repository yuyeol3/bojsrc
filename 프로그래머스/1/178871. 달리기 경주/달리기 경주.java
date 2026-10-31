import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rMap.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int idx = rMap.get(callings[i]);
            String tmp = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = tmp;
            
            rMap.put(callings[i], rMap.get(callings[i])-1);
            rMap.put(tmp, rMap.get(tmp)+1);
        }
        
        return players;
    }
}