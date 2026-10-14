import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // Arrays.sort(phone_book, (a, b)->Integer.compare(a.length(), b.length()));
        // Map<String, List<String>> dict = new HashMap<>();  
        Set<String> dict = new HashSet<>(Arrays.asList(phone_book));
        
        for (String s : phone_book) {
            for (int i = 0; i < s.length()-1; i++) {
                String substr = s.substring(0, i+1);
                if (dict.contains(substr)) {
                    return false;
                }
            }
            // dict.add(s);
        }
            
        return true;
    }
}