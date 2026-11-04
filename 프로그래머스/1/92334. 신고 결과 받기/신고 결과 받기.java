import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportedBy = new HashMap<>();
        for (String s : report) {
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            
            reportedBy.computeIfAbsent(reported, (ky)->new HashSet<>()).add(reporter);
        }
        
        Map<String, Integer> receivedNoti = new HashMap<>();
        
        for (String key : id_list) {
            if (reportedBy.get(key) != null && reportedBy.get(key).size() >= k) {
                
                for (String reporter : reportedBy.get(key)) {
                    receivedNoti.put(
                        reporter, 
                        receivedNoti.getOrDefault(reporter, 0) + 1
                    );
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = receivedNoti.getOrDefault(id_list[i], 0);
        }
        
        
        return answer;
    }
}