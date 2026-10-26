import java.util.*;

class Solution {
    boolean solution(String s) {

        // Deque<Character> q = new ArrayDeque<>();
        int q = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                q++;
            }
            else {
                if (q == 0) {
                    return false;
                }
                else {
                    q--;
                }
            }
            
        }
        

        return (q == 0) && true;
    }
}