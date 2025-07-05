#include <bits/stdc++.h>
using namespace std;

int dp[12];

int main() {
    int n;
    cin >> n;

    int tc[n];
    int mx = 0;
    for (int i = 0; i < n; i++) {
        cin >> tc[i];
        mx = max(mx, tc[i]);
    }

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i <= mx; i++) {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    for (int t : tc) {
        cout << dp[t] << '\n';
    }

    return 0;
}