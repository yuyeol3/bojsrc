#include <bits/stdc++.h>
using namespace std;

int dp[20];

// void printArr(int *arr, int n) {
//     for (int i = 0; i < n; i++) {
//         cout << arr[i] << ' ';
//     }
//     cout << '\n';
// }

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int T;
    cin >> T;
    while (T--) {
        // dp[i] : n 번째 수를 만드는 경우의 수수
        int n;
        cin >> n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; // 11, 2
        dp[3] = 4; // 111, 12, 21
        for (int i = 4; i <= n; i++) {
            dp[i] = 0;
            if (i-1 > 0) dp[i] += dp[i-1];
            if (i-2 > 0) dp[i] += dp[i-2]; // 112 121 212
            if (i-3 > 0) dp[i] += dp[i-3];
        }
        // printArr(dp, n+1);
        cout << dp[n] << '\n';
    }
}