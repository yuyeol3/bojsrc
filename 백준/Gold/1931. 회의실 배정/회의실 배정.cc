#include <bits/stdc++.h>
using namespace std;


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    pair<int, int> c[n];

    for (int i = 0; i < n; i++)
        cin >> c[i].first >> c[i].second;

    sort(c, c+n, [](pair<int, int> a, pair<int, int> b) -> bool {return a.first < b.first;});
    sort(c, c+n, [](pair<int, int> a, pair<int, int> b) -> bool {return a.second < b.second;});
    // print_arr(c, n);

    pair<int, int> *prev = c;
    int cnt = 1;
    for (int i = 1; i < n; i++) {
        if (c[i].first >= prev->second) {
            prev = c + i;
            cnt++;
        }
    }

    cout << cnt << '\n';
}