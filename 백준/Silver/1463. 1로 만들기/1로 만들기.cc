#include <bits/stdc++.h>
using namespace std;

const int MX = 1000002;
int dp[MX];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N;
    cin >> N;
    dp[1] = 0;
    for (int i = 2; i <= N; i++) {
        int minimum = INT_MAX;
        if (i % 3 == 0) minimum = min(dp[i / 3] + 1, minimum);
        if (i % 2 == 0) minimum = min(dp[i / 2] + 1, minimum);
        minimum = min(dp[i-1] + 1, minimum);
        dp[i] = minimum;
    }
    cout << dp[N] << '\n';
}