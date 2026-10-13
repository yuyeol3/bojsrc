import java.util.*;


class Solution {
    int getElv(int n) {
        int result = 1;
        for (int i = 0; i < n - 1; i++) {
            result *= 10;
            result += 1;
        }
        
        return result;
    }
    
    public int solution(int N, int number) {        
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) 
            dp.add(new HashSet<>());
        
        // dp.get(1).add(N);
        
        
        for (int i = 1; i < 9; i++) {
            
            for (int k = 1; k <= i / 2; k++) {
                
                Set<Integer> aSet = dp.get(k);
                Set<Integer> bSet = dp.get(i-k);
                
                for (int a : aSet) {
                    for (int b : bSet) {
                        dp.get(i).add(a*b);
                        dp.get(i).add(a+b);
                        
                        if (b != 0) dp.get(i).add(a/b);
                        if (a != 0) dp.get(i).add(b/a);
                        
                        dp.get(i).add(a-b);
                        dp.get(i).add(b-a);
                    }
                }
                
            }
            dp.get(i).add(N * getElv(i));
            
            if (dp.get(i).contains(number)) {
                IO.println(dp.get(i).size());
                return i;
            }
        }
        IO.println(dp.get(8).size());
        return -1;
    }
    
    

}

/*
5 1개 쓰는 경우 5
5 2개 쓰는 경우
55 5+5 5*5 5/5

555 55+5 5+5+5 5*5+5 5/5+5 

k*10+5

k+5

k*5

k/5


r->i?
i->r?

어떤 수 x를 사칙연산과 N만으로 만드는 데 필요한 횟수를 구하는 함수를 f(x) 형태라고 하자


x==N이면 f=1
x==N*10+N 이면 f=2

1 : 5
2 : 5+5, 5/5, 5*5, 5-5 (10, )


p op q 형태로 나타나야함

p op q = number 이고
dp[p] + dp[q] = dp[number]임

dp[k] = min(~) + ~



*/