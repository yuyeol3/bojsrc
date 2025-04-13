#include <bits/stdc++.h>
using namespace std;

int dp[305] = {0};
int arr[305];
int N;

// n번째를 반드시 포함하는 최대 점수
int f(int n) {
    if (n < 0) return 0;
    if (dp[n]) return dp[n];

    dp[n]= max(arr[n]+arr[n-1]+f(n-3), arr[n]+f(n-2));
    return dp[n];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    dp[0] = arr[0];
    cout << f(N-1) << '\n';

    return 0;
}