#include <cstdio>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

vector<int> coins;
int dp[10001][100];

int f(int n, int idx) {
    if (n < 0)               return -1;
    if (idx >= coins.size()) return -1;
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

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    // dp.resize(k+1, vector<int>(n+1, -1));
    for (int i = 0; i < 10001; ++i) {
        for (int j = 0; j < 100; ++j)
            dp[i][j] = -1;
    }

    coins.resize(n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &coins[i]);
    }
    sort(coins.begin(), coins.end(), [](int a, int b) -> bool { return a > b; });
    printf("%d\n", f(k, 0));
    return 0;
}