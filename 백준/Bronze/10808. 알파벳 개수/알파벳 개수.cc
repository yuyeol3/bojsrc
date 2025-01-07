#include <bits/stdc++.h>
using namespace std;

int ccount[26];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string s;
    cin >> s;

    for (char c : s)
        ccount[c - 'a']++;

    for (int e : ccount)
        cout << e << ' ';
    cout << '\n';
    return 0;
}