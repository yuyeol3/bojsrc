#include <bits/stdc++.h>
using namespace std;

const int MX = 10005;
int dat[MX];
int head = 0, tail = 0;

void push(int x) {
    dat[tail++] = x;
}

void pop() {
    head++;
}

int front() {
    return dat[head];
}

int back() {
    return dat[tail-1];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    string command;
    for (int i = 0; i < N; i++) {
        cin >> command;
        if (command == "push") {
            int t;
            cin >> t;
            push(t);
        }
        else if (command == "pop") {
            if (!(tail-head==0))  {
                cout << front() << '\n';
                pop();
            }
            else cout << -1 << '\n';
        }
        else if (command == "size") {
            cout << tail - head << '\n';
        }
        else if (command == "empty") {
            cout << (tail - head == 0) << '\n';
        }
        else if (command == "front") {
            if (!(tail-head==0)) cout << front() << '\n';
            else cout << -1 << '\n';
        }
        else if (command == "back") {
            if (!(tail-head==0)) cout << back() << '\n';
            else cout << -1 << '\n';
        }
    }
    return 0;
}