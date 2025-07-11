#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n, k;
    cin >> n >> k;

    int c[n];
    for (int i = 0; i < n; i++)
        cin >> c[i];

    int tot = 0;
    int left = k;
    for (int i = n-1; i >= 0; i--) {
        tot += left / c[i];
        left = left % c[i];
    }
    cout << tot << '\n';
}