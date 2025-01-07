#include <bits/stdc++.h>
using namespace std;

int dcount[10];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int a, b, c;
    cin >> a >> b >> c;
    int calc = a * b * c;

    string scalc = to_string(calc);

    for (char c : scalc)
       dcount[c - '0']++;

    for (int i = 0; i < 10; i++)
        cout << dcount[i] << '\n';
    return 0;
}