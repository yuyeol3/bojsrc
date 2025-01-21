#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    int good = 0;
    for (int i = 0; i < N; i++) {
        string word;
        cin >> word;

        stack<char> s;
        for (char c : word) {
            if (s.empty() || s.top() != c)
                s.push(c);
            else if (s.top() == c) {
                s.pop();
            }
        }

        if (s.empty()) good++;
    }

    cout << good << '\n';
}