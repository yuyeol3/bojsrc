import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> yearningByName = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            yearningByName.put(name[i], yearning[i]);
        }
        
        
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (String n : photo[i]) {
                result[i] += yearningByName.getOrDefault(n, 0);
            }
        }
        return result;
    }
}