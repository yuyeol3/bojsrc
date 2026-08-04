import java.util.*;

class Solution {
    long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        
        return a;
    }
    
    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        
        return Math.abs(a*b / gcd(a,b));
    }
    
    long lcmAll(long[] nums) {
        long result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            result = lcm(result, nums[i]);
            
            if (result == 0) {
                return 0;
            }
        }
        
        return result;
    }
    
    boolean isYellow(int g, int y, int r, int t) {
        /*
            r + g + b 
            n = (t_st - g) / (g+r+y) = ((t_ed) - (g+y))/(g+r+y)
        */
        
        int n = (t - g - 1) / (g+r+y);
        int st = g+1 + (g+r+y) * n;
        
        return st <= t && t < st + y;
    }
    
    public int solution(int[][] signals) {        
        int n = signals.length;
        boolean isImpossible = false;
        long[] coeffs = new long[n];
        
        for (int i = 0; i < n; i++) {
            coeffs[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n-1; j++) {
                int aG = signals[i][0];
                int aY = signals[i][1];
                
                int bG = signals[j][0];
                int bY = signals[j][1];
                
                if (coeffs[i] == coeffs[j] &&
                    !((aG <= bG && bG < aG + aY) ||
                      (aG < bG+bY && bG+bY <= aG + aY))    
                )
                    return -1;
            }
        }
        
        
        int t = 1;
        long lim = lcmAll(coeffs);
        while (t <= lim) {
            for (int i = 0; i < n; i++) {
                if (!isYellow(signals[i][0], signals[i][1], signals[i][2], t))
                    break;
                
                if (i == n-1) 
                    return t;
            }
            t++;
        }
        
        return -1;
    }
}