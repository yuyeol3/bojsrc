#include <bits/stdc++.h>
using namespace std;

int main() {
    string code;
    cin >> code;

    string tok = "";
    char mode = '0';
    int result = 0;
    for (char c : code) {
        if (mode == '0') {
            if (c == '+') {
                result += stoi(tok);
                tok = "";
            }
            else if (c == '-') {
                result += stoi(tok);
                tok = "";
                mode = '-';
            }
            else {
                tok += c;
            }
            
        }
        else if (mode == '-') {
            if (c == '+' || c == '-') {
                result -= stoi(tok);
                tok = "";
            }
            else {
                tok += c;
            }
        }
    }

    result += (mode == '-' ? -1 : 1) * stoi(tok);

    cout << result << '\n';
    
}