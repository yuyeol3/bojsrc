import java.util.*;
/*
*++*++ (3+2)*3+2 => 17
*+*+++ 15



*++*++*++


(*)*++*++(++)  (17=>37)
(*+)*++*++(+)
(*++)*++*++()


*++*++*++

2k (왼쪽으로 움직인 칸 개수) x 3^n (뒤에 있는 별의 개수)

*++ => 5

(*)*++(++) 13 (5=>13)
(*+)*++(+) 15
(*++)*++() 17

문자열의 길이가 n일 때, k라는 음 높이를 만족할 수 있는 개수???

(문자열의 길이는 3의 배수임)


*++*++  17(~13)
*+*+++  15
**++++

*++*++*++ = 17*3+2 ~ 17*3+2 - 4
*+*+++*++ = 15*3+2 ~ 15*3+2 - 6
**++++*++ = 13*3+2 ~ 13*3+2 - 8

(n - 2) / 3 을 하거나
-2씩 빼거나?

값을 계산하는 거 자체는 별로 비용이 안들고
근데 아무래도 문자열은 경우의수가많음


3*n

dp[n][k] -> pitch
n은 문자열 길이
k는 trailing +

dp[1][2] = 5
*++


*++*++
dp[2][2] = 17
dp[2][3] = 15
dp[2][4] = 13


int getNum(int pitchLevel) {
    
    getNum(길이가 )
    
}

별이 n개이면 더하기는 2n개

***....*++

****++

(n)^(2n-2)

f(0) => 0
f(1) =>
f(2) =>
f(3)
f(4)
f(5) => 1
f(6) => 0
f(7) => 0


3^n + 2 * 3^(n-1) ~ 2 * 3 + 2 (최대)

3^n + 2n (최소)

n = 3^x + 2 * 3^(x-1) + .... + 2

2, 4, ..., 2x개로 각각 자리가 제한된다고 할 때...

그 숫자를 만들 수 있는 가짓수?

백트래킹으로 가능할지 잘 모르겠는데 음...

n - 3^x = _ * 3^(x-1)

*/


class Solution {
    int calc(String s) {
        int val = 1;
        for (char c : s.toCharArray()) {
            if (c == '+') val++;
            else if (c == '*') val *= 3;
        }
        return val;
    }
    
    long lengthMax(int n) {
        long result = 1;
        
        for (int i = 0; i < n; i++) {
            result *= 3;
            result += 2;
        }
        
        return result;
    }
    
    long lengthMin(int n) {
        long result = 1;
        
        for (int i = 0; i < n; i++) {
            result *= 3;
        }
        
        result += 2*n;
        return result;
    }
    
    int calcMaximum(int from, int to, int leftPlus) {
        
        int sum = 0;
        for (int i = to; i >= from; i--) {
            sum += 2 * (int) Math.pow(3, i);
            leftPlus -= 2;
            if (leftPlus <= 0) return sum;
        }
        
        return sum;
    }
    
    
    int backtracking(int x, int r, int leftVal, int leftPlus) {
        

        if (leftVal < 0 || leftPlus < 0) return 0;
        // if (leftVal % 3 != 0) return 0;
        // if (leftPlus * (int) Math.pow(3, x-1) < leftVal) return 0;
        // if (calcMaximum(r,x-1, leftPlus) < leftVal) return 0;
        if (leftPlus > 2 * (x - r)) return 0;
        if (x == r) {
            return leftVal == 0 && leftPlus == 0 ? 1 : 0;
        }
        
        int st = r == 0 ? 2 : 0;
        int ed = 2*(x - r);
        int result = 0;
        for (int i = st; i <= ed; i++) {
            int next = leftVal - i;
            if (next % 3 != 0) continue;
            next /= 3;
            result += backtracking(x, r+1, next, leftPlus-i);
        }
        
        return result;
    }
    
    public int solution(int n) {
        
        int lb = 1;
        int ub = 30;
        
        int x = 0;
        while (lb < ub) {
            int mid = (lb+ub)/2;
            
            long minVal = lengthMin(mid);
            long maxVal = lengthMax(mid);
            
            if (n >= minVal && n <= maxVal) {
                x = mid;
                break;
            }
            else if (n < minVal) {
                ub = mid;
            }
            else if (n > maxVal) {
                lb = mid + 1;
            }
        }
        
        return backtracking(x, 0, n-(int)Math.pow(3, x), 2*x);
        // *+*+++
        // (3+1)*3+3
        // 3^2 + 3 + 3
        
        // return x;
    }
}