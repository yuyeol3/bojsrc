#include <iostream>
#define MAX_N 91
using namespace std;

long long dp[MAX_N];

long long f(int n) {
    if (n <= 0) return 0; 
    if (n == 1) return 1;
    if (dp[n] != -1) return dp[n];

    long long res = 1;
    for (int i = 1; i < n -1; ++i) {
        res += f(i);
    }
    dp[n] = res;
    return res;
}

int main() {
    int n;
    scanf("%d", &n);
    fill(dp, dp+MAX_N, -1);
    printf("%lld\n", f(n));
    return 0;
}