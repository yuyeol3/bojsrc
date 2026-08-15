import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int cityNum = g.length;

        long st = 0;
        long ed = (long) 1e15;
        
        while (st <= ed) {
            long mid = (st + ed) / 2;
            
            long gold = 0;
            long silver = 0;
            long tot = 0;
            
            for (int i = 0; i < cityNum; i++) {
                long deliveryCount = (mid / t[i] + 1) / 2;
                long deliveryAmount =  w[i] * deliveryCount;
                gold += Math.min(deliveryAmount, g[i]);
                silver += Math.min(deliveryAmount, s[i]);
                tot += Math.min(deliveryAmount, g[i]+s[i]);
            }
            
            if (gold >= a && silver >= b && tot >= a+b) {
                ed = mid-1;                
            }
            else {
                st = mid+1;
            }
        }
        
        return st;
    }
}