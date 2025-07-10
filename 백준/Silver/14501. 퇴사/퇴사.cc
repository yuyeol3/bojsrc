#include <bits/stdc++.h>
using namespace std;

int t[16], p[16], dp[16];
int n;

void print_arr(int *p, int n) {
    for (int i = 0; i < n; i++) {
        cout << p[i] << ' ';
    }
    cout << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> t[i] >> p[i];
        if (i + t[i] <= n) dp[i] = p[i];
    }
    // print_arr(dp, n);

    // dp[i] : i번째를 포함하는 스케줄 중 최대값
    for (int i = 0; i < n; i++) {
        if (i + t[i] > n) continue;
        for (int j = 0; j < i; j++) {
            if (j + t[j] <= n && t[j] + j <= i) 
                dp[i] = max(dp[i], dp[j] + p[i]);
            // print_arr(dp, n);
        }
    }

    cout << *max_element(dp, dp+n);
}