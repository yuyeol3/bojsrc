#include <cstdio>
#include <vector>
#define MAX 1001
using namespace std;

int dp[MAX][MAX];
vector<int> series;

/*
 * idx부터 가장 큰 증가 수열의 합을 구하는 함수
 */
int f(int idx, int prev) {
    // printf("%d %d\n", idx, prev);
    if (idx >= series.size()) return 0;
    if (dp[idx][prev] != -1) return dp[idx][prev];

    int res = f(idx+1, prev);
    if (series[idx] > prev) res = max(res, 1 + f(idx+1, series[idx]));

    dp[idx][prev] = res;
    return res;
}

int main() {
    int N;
    scanf("%d", &N);
    series.resize(N);

    int max = 0;
    for (int i = 0; i < N; ++i) {
        scanf("%d", &series[i]);
        if (series[i] > max)
            max = series[i];
    }

    for (int i = 0; i < N + 1; ++i) {
        for (int j = 0; j < max + 1; j++) {
            dp[i][j] = -1;
        }
    }

    printf("%d\n", f(0, 0));

    return 0;
}