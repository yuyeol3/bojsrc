import java.util.*;

/*

dp[lvl][pos] = triangle[lvl][pos] +  max(dp[lvl+1][pos], dp[lvl+1][pos+1])
*/

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;        
        int[][] dp = new int[N][N];

        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + (
                    i == N-1 ? 
                    0 :
                    Math.max(dp[i+1][j], dp[i+1][j+1])
                );
            }
        }
        
        
        return dp[0][0];
    }
}