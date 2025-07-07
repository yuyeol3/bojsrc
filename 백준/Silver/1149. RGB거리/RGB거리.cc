#include <bits/stdc++.h>
using namespace std;

int h[1001][3];
int dp[1001][3];


int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> h[i][0] >> h[i][1] >> h[i][2];
    }

    // dp[i][j] : i번째 집에 대한 색깔이 j일때 비용의 최솟값
    for (int i = 0; i < 3; i++) 
        dp[0][i] = h[0][i];


    for (int i = 1; i < n; i++) {
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + h[i][0];
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + h[i][1];
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + h[i][2];
    }


    cout << min({dp[n-1][0], dp[n-1][1], dp[n-1][2]}) << '\n';
    return 0;
} 