#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;

    int a[n], b[n];

    for (int i = 0; i < n; i++)
        cin >> a[i];

    for (int i = 0; i < n; i++)
        cin >> b[i];

    sort(a, a+n);
    sort(b, b+n, [](int a, int b)-> bool {
        return a > b;
    });

    int res = 0;
    for (int i = 0; i < n; i++) {
        res += a[i] * b[i];
    }
    cout << res;
}