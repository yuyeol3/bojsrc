#include <cstdio>
#include <algorithm>
using namespace std;

int dp[41][2];

int fibo01(int n, int target) {
    if (dp[n][target] != -1) {
        return dp[n][target];
    }

    if (n == 0) {
        dp[0][0] = 1;
        dp[0][1] = 0;
        return dp[0][target];
    }
    if (n == 1) {
        dp[1][0] = 0;
        dp[1][1] = 1;
        return dp[1][target];
    }

    dp[n][target] = fibo01(n-1,target) + fibo01(n-2,target);
    return dp[n][target];
}

int main() {
    int t;
    scanf("%d", &t);
    for (int tcn = 0; tcn < t; ++tcn) {
        int n;
        scanf("%d", &n);
        // dp배열 초기화
        for (int i = 0; i < n+1; ++i) {
            for (int j = 0; j < 2; ++j) {
                dp[i][j] = -1;
            }
        }

   
        printf("%d %d\n", fibo01(n,0), fibo01(n,1));
    }


    return 0;
}