#include <bits/stdc++.h>
using namespace std;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string line;
    while (true) {
        getline(cin, line, '\n');

        if (line == ".") break;

        stack<char> s;
        bool isValid = true;
        for (char c : line) {
            if (c == '(' || c == '{' || c == '[') s.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (s.empty()) {
                    isValid = false;
                    break;
                }

                if (c == ')') {
                    if (s.top() =='(')
                        s.pop();
                
                    else {
                        isValid = false;
                        break;
                    }
                }
                else if (c == '}') {
                    if (s.top() == '{') 
                        s.pop();
                    
                    else {
                        isValid = false;
                        break;
                    }
                }
                else if (c == ']') {
                    if (s.top() == '[') 
                        s.pop();
                    
                    else {
                        isValid = false;
                        break;
                    }
                }
            }
            
        }

        if (s.empty() && isValid)
            cout << "yes" << '\n';
        else
            cout << "no" << '\n';
    };
} 