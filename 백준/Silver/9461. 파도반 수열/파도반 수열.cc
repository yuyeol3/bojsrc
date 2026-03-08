#include <bits/stdc++.h>
using namespace std;

using ll = long long;

ll dp[105] = {0};
int T;

/**

1
1
1
2
2
3

 */

ll P(int n) {
    if (n <= 3) return 1;
    if (dp[n]) return dp[n];

    dp[n] = P(n-2) + P(n-3);
    return dp[n];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> T;
    for (int i = 0; i < T; i++) {
        int N;
        cin >> N;
        cout << P(N) << '\n';
    }

    return 0;
}