#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string data;
    cin >> data;
    int open = 0;
    int totPiece = 0;
    char prev = '\0';
    for (char c : data) {
        
        if (c == ')') {
            open--;
            if (prev == '(')
                totPiece += open;
            else
                totPiece++;
        }
        else open++;
        prev = c;
    }

    cout << totPiece << '\n';
}