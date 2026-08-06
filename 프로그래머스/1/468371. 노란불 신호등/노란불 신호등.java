import java.util.*;

class Solution {
    long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
    
    long lcm(long a, long b) {
        if (a == 0 || b == 0) 
            return 0;
        
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
    
    boolean isYellow(int g, int y, int r, long t) {
        /*
            r + g + b 
            n = (t_st - g) / (g+r+y) = ((t_ed) - (g+y))/(g+r+y)
        */
        
        long period = (long) g + y + r;
        long pos = (t-1) % period;
        
        return g <= pos && pos < (long) g + y;
    }
    
    public int solution(int[][] signals) {        
        int n = signals.length;
        long[] coeffs = new long[n]; // 주기
        
        for (int i = 0; i < n; i++) {
            coeffs[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        
        long lim = lcmAll(coeffs);
        
        for (long t = 1; t <= lim; t++) {
            for (int i = 0; i < n; i++) {
                if (!isYellow(signals[i][0], signals[i][1], signals[i][2], t))
                    break;
             
                if (i == n-1) 
                    return (int) t;
            }
        }
        
        return -1;
    }
}