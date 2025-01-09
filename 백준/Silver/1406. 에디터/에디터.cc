#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000000;
char dat[MAX];
int prv[MAX], nxt[MAX];
int usable = 1;
int len = 0;

void traverse() {
    int cur = nxt[0];
    while (cur != -1) {
        cout << dat[cur];
        cur = nxt[cur];
    }
    cout << '\n';
}

void add(int addr, char data) {
    dat[usable] = data;
    prv[usable] = addr;
    nxt[usable] = nxt[addr];

    if (nxt[addr] != -1) prv[nxt[addr]] = usable;
    nxt[addr] = usable;
    usable++;
    len++;
}

void erase(int addr) {
    if (nxt[addr]!= -1) prv[nxt[addr]] = prv[addr];
    nxt[prv[addr]] = nxt[addr];
    len--;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    fill(prv, prv+MAX, -1);
    fill(nxt, nxt+MAX, -1);

    string ln;
    cin >> ln;

    for (char c : ln) add(len, c);

    int cursor = len; // 제일 마지막 단어
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        char command;
        cin >> command;

        switch (command) {
            case 'L':
                if (cursor != 0) cursor = prv[cursor];
                break;
            case 'D':
                if (nxt[cursor] != -1) cursor = nxt[cursor];
                break;
            case 'B':
                if (cursor != 0) {
                    erase(cursor);
                    cursor = prv[cursor];
                }
                break;
            case 'P':
                cin >> command;
                add(cursor, command);
                cursor = usable - 1;
                break;
        }
    }

    traverse();
    return 0;
}
