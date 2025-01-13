#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    stack<int> s;
    int K;
    for (int i = 0; i < N; i++) {
        cin >> K;
        switch (K) {
            case 0:
                s.pop();
                break;
            default:
                s.push(K);
                break;
        }
    }

    int sum = 0;
    while (!s.empty()) {
        sum += s.top();
        s.pop();
    }
    cout << sum << '\n';
    return 0;
}