#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string data;
    cin >> data;
    stack<char> s;

    int totPiece = 0;
    char prev = '\0';
    for (char c : data) {
        
        if (c == ')') {
            s.pop();
            if (prev == '(')
                totPiece += s.size();
            else
                totPiece++;
        }
        else s.push(c);
        prev = c;
    }

    cout << totPiece << '\n';
}