import java.util.*;

class Solution {
    int toSerial(String dateString) {
        // IO.println(dateString);
        String[] ymd = dateString.split("\\.");
        
        int y = Integer.parseInt(ymd[0]) - 2000;
        int m = Integer.parseInt(ymd[1]);
        int d = Integer.parseInt(ymd[2]);
        return y * 12 * 28 + m * 28 + d;
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        
        int todaySerial = toSerial(today);
        
        Map<String, Integer> termPeriod = new HashMap<>();
        for (String term : terms) {
            String[] tm = term.split(" ");
            termPeriod.put(tm[0], Integer.parseInt(tm[1]) * 28);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] pt = privacies[i].split(" ");
            // IO.println(pt[0] + " " + pt[1]);
            int dateSerial = toSerial(pt[0]);
            if (todaySerial-dateSerial >= termPeriod.get(pt[1])) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}