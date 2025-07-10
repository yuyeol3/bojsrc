#include <bits/stdc++.h>
using namespace std;

const int MX = 1500001;

int t[MX], p[MX], dp[MX];
int n;

void print_arr(int *p, int n) {
    for (int i = 0; i < n; i++) {
        cout << p[i] << ' ';
    }
    cout << '\n';
}



int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> t[i] >> p[i];
        if (i + t[i] <= n) dp[i] = p[i];
    }

    // O(N) 알고리즘이 필요
    /*
    특징 : 각 상담마다 특정 날짜 이후에 다음 상담이 가능해지는 제약 조건이 생긴다.

    */
    int use[n];
    fill(use, use+n, -1);

    for (int i = 0; i < n; i++) {
        if (i+1 < n && (use[i+1] == -1 || dp[use[i]] > dp[use[i+1]])) 
            use[i+1] = use[i]; // propagate
        if (i + t[i] > n) continue;
        if (use[i] != -1)
            dp[i] = p[i] + dp[use[i]];

        if (t[i] + i == n) continue;
        if (use[t[i] + i] == -1 || dp[use[t[i] + i]] < dp[i] )
            use[t[i] + i] = i;
        // print_arr(dp, n);
    }

    cout << *max_element(dp, dp+n);
    // cout << dp[n-1] << '\n';
}