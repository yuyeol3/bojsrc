#include <bits/stdc++.h>
using namespace std;
#define MX 1002

int dp[MX][MX];
int S[MX];
int N;

int f(int i, int prev) {
    if (i >= N) return 0;
    if (dp[i][prev]) return dp[i][prev];

    dp[i][prev] = max(
        f(i+1, prev),
        S[i] < prev ? 1 + f(i+1, S[i]) : -1
    );

    return dp[i][prev];
}

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> S[i];
    }

    cout << f(0, 1001) << '\n';
}