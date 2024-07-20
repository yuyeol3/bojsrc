#include <cstdio>
#include <vector>
#include <cmath>
#include <algorithm>
#include <climits>
using namespace std;

int main() {
    int N;
    scanf("%d", &N);
    vector<int> dp(N+1, INT_MAX);
    dp[0] = 0;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j*j <= i; j++) {
            dp[i] = min(dp[i], dp[i - j*j] + 1);
        }
    }

    printf("%d\n", dp[N]);
    return 0;
}