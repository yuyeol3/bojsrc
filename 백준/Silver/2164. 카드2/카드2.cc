#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    queue<int> q;

    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        q.push(i+1);
    }

    while (q.size() > 1) {
        q.pop();
        q.push(q.front());
        q.pop();
    }

    cout << q.front() << '\n';

    return 0;
}