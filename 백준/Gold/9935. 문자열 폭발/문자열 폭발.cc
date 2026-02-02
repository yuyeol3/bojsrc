#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string s, k;
    cin >> s >> k;

    char stk[s.length()];
    int top = 0;

    for (int i = 0; i < s.length(); i++) {
        stk[top++] = s[i];

        if (stk[top-1] == k[k.length() - 1]) {
            int base = top - k.length();
            bool isBomb = base < 0 ? false : true;

            for (int j = 0; isBomb && j < k.length(); j++) {
                if (stk[base+j] != k[j]) isBomb = false;   
            }

            top -= (isBomb) * k.length();
        }
    }

    if (top == 0) cout << "FRULA";
    else for (int i = 0; i < top; i++) {
            cout << stk[i];
    }

    return 0;
}