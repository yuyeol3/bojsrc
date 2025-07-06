#include <bits/stdc++.h>
using namespace std;

int s[301];
int dp[301];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }

    dp[0] = s[0];
    dp[1] = s[0] + s[1];
    dp[2] = max(s[0], s[1]) + s[2];

    for (int i = 3; i < n; i++) {
        dp[i] = max(s[i]+s[i-1]+dp[i-3], s[i]+dp[i-2]);
    }

    cout << dp[n-1] << '\n';
    return 0;
}