#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string bstr;
    cin >> bstr;
    
    stack<char> s;
    stack<int> vbuff;
    int result = 0;
    bool isValid = true;
    for (char c : bstr) {
        if (c == '[' || c == '(') {
            s.push(c);
            vbuff.push(1);
            // result += vbuff;
        }
            
        else if (!s.empty() && c ==')') {
            if (s.top() != '(') {
                isValid = false;
                break;
            }
            s.pop();
            

            if (vbuff.top() == 1) {
                vbuff.pop();
                vbuff.push(2);
            }
            else {
                int sum = 0;
                while (vbuff.top() != 1) {
                    sum += vbuff.top();
                    vbuff.pop();
                }
                vbuff.pop();
                vbuff.push(sum * 2);
            }

            // vbuff *= 2;
        }
        else if (!s.empty() && c == ']') {
            if (s.top() != '[') {
                isValid = false;
                break;
            }
            s.pop();

            if (vbuff.top() == 1) {
                vbuff.pop();
                vbuff.push(3);
            }
            else {
                int sum = 0;
                while (vbuff.top() != 1) {
                    sum += vbuff.top();
                    vbuff.pop();
                }
                vbuff.pop();
                vbuff.push(sum * 3);
            }
            // vbuff *= 3;
        }
        else {
            isValid = false;
            break;
        }

        if (s.empty()) {
            int sum = 0;
            while (!vbuff.empty()) {
                sum += vbuff.top();
                vbuff.pop();
            }
            result += sum;
        }

    }

    if (!s.empty()) isValid = false;
    if (isValid) cout << result << '\n';
    else cout << 0 << '\n';
}