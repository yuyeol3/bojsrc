#include <bits/stdc++.h>
using namespace std;

int tr[501][501];
int dp[501][501];
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
            cin >> tr[i][j];
        }
    }

    // dp[i][j] : (i, j) 를 포함하는 (i, j)까지의 가장 큰 경로의 수 합
    dp[0][0] = tr[0][0];
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
            int maxi = -1;
            if (j != 0) maxi = max(maxi, dp[i-1][j-1]);
            if (j != i) maxi = max(maxi, dp[i-1][j]);
            dp[i][j] = maxi + tr[i][j];
            // cout << dp[i][j] << ' ';
        }
        // cout << '\n';
    }

    cout << *max_element(dp[n-1], dp[n-1]+n) << '\n';
    return 0;
}