#include <bits/stdc++.h>
using namespace std;

int n;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    int s[n], e[n];
    for (int i = 0; i < n; i++) {
        cin >> s[i] >> e[i];
    }
    sort(s, s+n);
    sort(e, e+n);
    
    int ep = 0;
    int sum = 0;
    int mx = 0;
    for (auto c : s) {
        sum++;
        while (e[ep] <= c) {
            sum--;
            ep++;
        }
        mx = max(mx, sum);
    }
    cout << mx;

    return 0;
}