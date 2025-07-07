#include <bits/stdc++.h>
using namespace std;

int dp[1000001];
int dir[1000001];

int f(int x) {
    if (x == 1) return 0;
    if (dp[x]) return dp[x];

    int r[3] = {
        x % 3 == 0 ? f(x / 3) : INT_MAX,
        x % 2 == 0 ? f(x / 2) : INT_MAX,
        f(x - 1)
    };
    int v[3] = {x/3, x/2, x-1};
    dp[x] = *min_element(r, r+3) + 1;
    dir[x] = v[min_element(r, r+3) - r];

    return dp[x];
}   

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int x;
    cin >> x;

    dir[1] = 0;
    dir[0] = 0;
    cout << f(x) << '\n';

    cout << x << ' ';
    int nxt = x;
    while (nxt != 1) {
        cout << dir[nxt] << ' ';
        nxt = dir[nxt];
    }
    return 0;
}