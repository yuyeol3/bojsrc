#include <bits/stdc++.h>
using namespace std;

template <typename T, size_t N>
constexpr array<T, N> calcCumulative(const array<T, N> &arr) {
    array<T, N> result{};

    if (N > 0) result[0] = arr[0];

    for (size_t i = 1; i < N; i++) 
        result[i] = result[i - 1] + arr[i];

    return result;
}

constexpr const array<int, 13> daysMonth 
    = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
constexpr auto daysCumlative = calcCumulative(daysMonth);

constexpr int date(int month, int date) {
    return date + daysCumlative[month-1];
}

int N;
// int st[100005], ed[100005];
int dp[366];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        int m1, d1, m2, d2;
        cin >> m1 >> d1 >> m2 >> d2;
        int st = date(m1, d1);
        int ed = date(m2, d2);
        dp[st] = max(dp[st], ed - st);
    }

    for (int d = date(1, 2); d <= date(12, 31); d++) {
        dp[d] = max(dp[d-1] -1, dp[d]); 
    }

    int answer = 0;
    int d = date(3, 1);
    while (d <= date(11, 30)) {
        if (dp[d] == 0) {
            cout << 0 << '\n';
            return 0;
        }

        answer++;
        d = d + dp[d];
    }
    cout << answer << '\n';
    return 0;
}