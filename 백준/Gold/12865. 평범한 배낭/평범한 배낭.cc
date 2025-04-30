#include <bits/stdc++.h>
using namespace std;

int dp[105][1000005];
int V[105], W[105];
int N, K;

/**
 * w만큼의 무게가 남았을 때, i를 넣을 경우의 최대 가치
 */
int f(int i, int w) {
    if (w <= 0 || i < 0) return 0;
    if (dp[i][w] != -1) return dp[i][w];

    if (w < W[i]) dp[i][w] = f(i-1, w);
    else dp[i][w] = max(f(i-1, w), f(i-1, w-W[i]) + V[i]);
    return dp[i][w];
}

int main() {
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        cin >> W[i] >> V[i];
    }

    for (int i = 0; i < N; i++)
        fill(dp[i], dp[i]+K+1, -1);
    
    cout << f(N-1, K) << '\n';
    return 0;
}