#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    int r[n];

    for (int i = 0; i < n; i++)
        cin >> r[i];

    sort(r, r+n, [](int a, int b)-> bool {
        return a > b;
    });

    // for (auto e : r) cout << e << '\n';
    
    int maxi = 0;
    for (int i = 0; i < n; i++) {
        maxi = max((i+1) * r[i], maxi);
    }
    cout << maxi << '\n';
}