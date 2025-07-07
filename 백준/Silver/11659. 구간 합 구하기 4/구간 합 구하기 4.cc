#include <bits/stdc++.h>
using namespace std;

int dp[100001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n, m;
    cin >> n >> m;

    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
        int t;
        cin >> t;
        dp[i] = dp[i-1] + t;
    }

    for (int t = 0; t < m; t++) {
        int i, j;
        cin >> i >> j;
        cout << dp[j] - dp[i-1] << '\n';
    }
    return 0;
    // 0 5 9 12 14 15

}