#include <bits/stdc++.h>
using namespace std;

long long dp[91];

int main() {
    int n;
    cin >> n;

    dp[1] = 1;
    dp[2] = 1;
    // dp[3] = 2;

    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }

    // for (auto e : dp) cout << e << '\n';
    // cout << '\n';
    cout << dp[n] << '\n';
}
