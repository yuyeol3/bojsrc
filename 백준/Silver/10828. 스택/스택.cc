#include <iostream>
using namespace std;

const int MAX = 10005;
int dat[MAX];
int pos = 0;

void push(int x) {
    dat[pos++] = x;
}

void pop() {
    pos--;
}

int top() {
    return dat[pos - 1];
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;
    
    string command;
    for (int i = 0; i < N; i++) {
        cin >> command;
        if (command == "push") {
            int num;
            cin >> num;
            push(num);
        }
        else if (command == "pop") {
            if (pos == 0) cout << -1 << '\n';
            else {
                cout << top() << '\n';
                pop();
            }
        }   
        else if (command == "size") {
            cout << pos << '\n';
        }
        else if (command == "empty") {
            cout << (pos == 0 ? 1 : 0) << '\n';
        }
        else if (command == "top") {
            if (pos == 0) cout << -1 << '\n';
            else cout << top() << '\n';
        }
    }

    return 0;
}