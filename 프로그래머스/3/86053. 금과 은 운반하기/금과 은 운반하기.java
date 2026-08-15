import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) 10e+15;
        int cityNum = g.length;

        long st = 0;
        long ed = (long) 10e+15;
        
        while (st <= ed) {
            long mid = (st + ed) / 2;
            
            long gold = 0;
            long silver = 0;
            long tot = 0;
            
            for (int i = 0; i < cityNum; i++) {
                long deliveryCount = mid / (2 * t[i]) + (mid % (2 * t[i]) >= t[i] ? 1 : 0);
                long deliveryAmount =  w[i] * deliveryCount;
                gold += Math.min(deliveryAmount, g[i]);
                silver += Math.min(deliveryAmount, s[i]);
                tot += Math.min(deliveryAmount, g[i]+s[i]);
            }
            
            if (gold >= a && silver >= b && tot >= a+b) {
                
                answer = Math.min(mid, answer);
                // System.out.printf("st, ed, mid : %d, %d, %d\n", st, ed, mid);
                ed = mid-1;                
            }
            else {
                st = mid+1;
            }
        }
        
        
        return answer;
    }
}