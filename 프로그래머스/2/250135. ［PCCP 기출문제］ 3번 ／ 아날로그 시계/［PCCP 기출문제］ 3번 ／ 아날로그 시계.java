class Solution {
    // 초침 -> 1초에 6도                   720
    // 분침 -> 1초에 360/3600 이니까 1/10도 12
    // 시침 -> 1초에 360/(3600*12) 1/120도 1
    final int MIN = 60;
    final int HOUR = 60*MIN;
    final int DAY = 12 * HOUR;
    final int ROUND = 120 * 360;
    
    int timeToSerial(int h, int m, int s) {
        return (h*HOUR + m * MIN + s);
    }

    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    
        int sTime = timeToSerial(h1, m1, s1);
        int eTime = timeToSerial(h2, m2, s2);
        int curTime = sTime;
        
        int answer = 0;
        if (sTime == timeToSerial(0, 0, 0))
            answer--;
        
        if (sTime <= timeToSerial(12, 0, 0) && timeToSerial(12, 0, 0) <= eTime)
            answer--;
        
        while (curTime <= eTime) {
            
            int hPrev = (curTime - 1) % ROUND;
            int mPrev = (12 *(curTime - 1)) % ROUND;
            int sPrev = (720 *(curTime - 1)) % ROUND;
            
            int hCur = hPrev + 1;
            int mCur = mPrev + 12;
            int sCur = sPrev + 720;
            
            if (curTime > sTime)  {
                if ((hPrev > sPrev) && (hCur < sCur)) 
                    answer++;
        
                if ((mPrev > sPrev) && (mCur < sCur))
                    answer++;
            }

            if (hCur == sCur) answer++;
            if (mCur == sCur) answer++;
        
            
            curTime++;
        }
        
        return answer;
    }
}