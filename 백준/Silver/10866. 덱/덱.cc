#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    deque<int> dq;

    int N;
    cin >> N;

    string command;
    for (int i = 0; i < N; i++) {
        cin >> command;
        if (command == "push_front") {
            int t;
            cin >> t;
            dq.push_front(t);
        }
        else if (command == "push_back") {
            int t;
            cin >> t;
            dq.push_back(t);
        }
        else if (command == "pop_front") {
            if (!dq.empty()) {
                cout << dq.front() << '\n';
                dq.pop_front();
            }
            else cout << -1 << '\n';
        }
        else if (command == "pop_back") {
            if (!dq.empty()) {
                cout << dq.back() << '\n';
                dq.pop_back();
            }
            else cout << -1 << '\n';
        }
        else if (command == "size") {
            cout << dq.size() << '\n';
        }
        else if (command == "empty") {
            cout << dq.empty() << '\n';
        }
        else if (command == "front") {
            if (!dq.empty()) cout << dq.front() << '\n';
            else cout << -1 << '\n';
        }
        else if (command == "back") {
            if (!dq.empty()) cout << dq.back() << '\n';
            else cout << -1 << '\n';
        }
    }
    return 0;
}