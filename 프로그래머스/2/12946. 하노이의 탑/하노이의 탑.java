import java.util.*;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> solution(int n) {
        hanoi(1, 3, 2, n);
        return answer;
    }
    
    public void hanoi(int from, int to, int via, int n) {
        if (n == 1) {
            answer.add(List.of(from, to));
            return;
        }
        
        hanoi(from, via, to, n-1);
        answer.add(List.of(from, to));
        hanoi(via, to, from, n-1);
    }
}