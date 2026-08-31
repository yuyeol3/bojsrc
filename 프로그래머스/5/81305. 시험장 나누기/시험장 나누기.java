import java.util.*;
class Solution {
    int totSplit;
    public int solution(int k, int[] num, int[][] links) {
        int n = num.length;
        int u = Arrays.stream(num).sum();
        int l = Arrays.stream(num).max().getAsInt();
        
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (links[i][0] != -1)
                indegree[links[i][0]]++;
            
            if (links[i][1] != -1)
                indegree[links[i][1]]++;
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                root = i;
                break;
            }
        }
        

        while (l <= u) {
            int criteria = (l+u) / 2;
            // criteria 이하로 트리를 나눌 수 있는지 검사
            // 나눌 수 있으면 u를 낮추고
            // 나눌 수 없으면 l을 올림
            
            // 문제 : criteria 이하로 트리를 나눌 수 있는지/없는지 어떻게 아는가            
            totSplit = 0;
            checkSplits(root, criteria, num, links);
            
            if (totSplit < k) {
                u = criteria - 1;
            }
            else {
                l = criteria + 1;
            }
        }
        // System.out.println(totSplit);
        return l;
    }
    
    int checkSplits(int root, int criteria, int[] num, int[][] links) {
        int top = num[root];
        
        int left = 0, right = 0;
        if (links[root][0] != -1) 
            left = checkSplits(links[root][0], criteria, num, links);            
        
        
        if (links[root][1] != -1)
            right = checkSplits(links[root][1], criteria, num, links);
        
        int sum;
        if (top + left + right <= criteria) {
            sum = top + left + right;
        }
        else if (top + left <= criteria || top + right <= criteria) {
            sum = top + Math.min(left, right);
            totSplit++;
        }
        else {
            sum = top;
            totSplit += 2;
        }

        
        return sum;
    }

    
}