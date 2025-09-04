#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
long long prefix_sum[MX];
int prices[MX];

int T;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> T;
    while (T--) {
        int N;
        cin >> N;
        for (int i = 1; i <= N; i++) {
            cin >> prices[i];
            prefix_sum[i] = prefix_sum[i-1] + prices[i];
        }
        int prev_idx = N;
        long long answer = 0;
        //  1 2 3 4 5 6
        prices[0] = MX;
        for (int i = N-1; i >= 0; i--) {
            if (prices[i] > prices[prev_idx]) {
                answer += (long long) prices[prev_idx] * (prev_idx - i - 1) - (prefix_sum[prev_idx - 1] - prefix_sum[i]);
                prev_idx = i;
            }
        }
        cout << answer << '\n';
    }
    return 0;
}