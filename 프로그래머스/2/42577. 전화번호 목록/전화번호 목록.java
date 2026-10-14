import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, (a, b)->Integer.compare(a.length(), b.length()));
        Map<String, List<String>> dict = new HashMap<>();        
        
        
        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                String substr = s.substring(0, i+1);
                if (dict.keySet().contains(substr)) {
                    return false;
                }
            }
            dict.computeIfAbsent(s, (k)->new ArrayList<>()).add(s);
        }
            
        return true;
    }
}