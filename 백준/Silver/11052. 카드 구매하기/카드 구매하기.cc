#include <cstdio>
#include <vector>
#define NMAX 1001
#define PMAX 10001
#define FAIL -1

using namespace std;

int dp[NMAX][PMAX];
int prices[PMAX];
int n;

int f(int num, int idx) {
    if (num == 0) return idx > n ? FAIL : 0;
    if (dp[num][idx] != -2) return dp[num][idx];

    int res = FAIL;
    if (n >= idx+1)   res = max(res, f(num, idx+1));
    if (num-idx >= 0) res = max(res, prices[idx]+f(num-idx, idx));

    dp[num][idx] = res;
    return res;
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i < n + 1; ++i) {
        scanf("%d", prices + i);
    }

    for (int i = 0; i < n+1; ++i) {
        for (int j = 0; j < n+1; ++j) {
            dp[i][j] = -2;
        }
    }

    printf("%d\n", f(n, 1));

    return 0;
}