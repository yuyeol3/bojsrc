#include <bits/stdc++.h>
using namespace std;

void print_arr(pair<int, int> *arr, int n) {
    for (int i = 0; i < n; i++) {
        cout << '(' << arr[i].first << ',' << arr[i].second << ')' << ' ';
    }
    cout << '\n';
}

int main() {
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