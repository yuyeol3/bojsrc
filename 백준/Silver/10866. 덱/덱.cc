#include <bits/stdc++.h>
using namespace std;

const int MAX = 10005;
int dat[MAX*2+1];
int head = MAX, tail = MAX;

void push_front(int x) {
    dat[--head] = x;
}

void push_back(int x) {
    dat[tail++] = x;
}

void pop_front() {
    head++;
}

void pop_back() {
    tail--;
}

int front() {
    return dat[head];
}

int back() {
    return dat[tail - 1];
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N;
    cin >> N;

    string command;
    for (int i = 0; i < N; i++) {
        cin >> command;
        if (command == "push_front") {
            int t;
            cin >> t;
            push_front(t);
        }
        else if (command == "push_back") {
            int t;
            cin >> t;
            push_back(t);
        }
        else if (command == "pop_front") {
            if (tail-head > 0) {
                cout << front() << '\n';
                pop_front();
            }
            else cout << -1 << '\n';
        }
        else if (command == "pop_back") {
            if (tail-head > 0) {
                cout << back() << '\n';
                pop_back();
            }
            else cout << -1 << '\n';
        }
        else if (command == "size") {
            cout << tail-head << '\n';
        }
        else if (command == "empty") {
            cout << !(tail-head) << '\n';
        }
        else if (command == "front") {
            if (tail-head>0) cout << front() << '\n';
            else cout << -1 << '\n';
        }
        else if (command == "back") {
            if (tail-head>0) cout << back() << '\n';
            else cout << -1 << '\n';
        }
    }
    return 0;
}