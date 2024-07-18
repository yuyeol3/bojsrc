#include <cstdio>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int coins[100];
int dp[10001][100];
int N;

int f(int n, int idx) {
    if (n < 0)               return -1;
    if (idx >= N) return -1;
    if (n == 0)              return 0;
    if (dp[n][idx] != -1)    return dp[n][idx] == 0 ? -1 : dp[n][idx];
    if (n < coins[idx])      return f(n, idx+1);

    int res = __INT_MAX__;
    int a,b,c;
    a = f(n, idx+1);
    b = 1 + f(n - coins[idx], idx+1);
    c = 1 + f(n - coins[idx], idx);

    if (a > 0) res = min(res, a);
    if (b > 0) res = min(res, b);
    if (c > 0) res = min(res, c);

    dp[n][idx] = (res == __INT_MAX__ ? 0 : res);
    return dp[n][idx] == 0 ? -1 : dp[n][idx];
}

void initDP() {
    for (int i = 0; i < 10001; ++i) {
        for (int j = 0; j < 100; ++j)
            dp[i][j] = -1;
    }
}

int main() {
    int k;
    scanf("%d %d", &N, &k);
    initDP();
    for (int i = 0; i < N; ++i) {
        scanf("%d", &coins[i]);
    }
    sort(coins, coins+101, [](int a, int b) -> bool { return a > b; });
    printf("%d\n", f(k, 0));
    return 0;
}