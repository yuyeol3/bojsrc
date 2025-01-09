#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    list<char> editor;
    list<char>::iterator cursor;

    string ln;
    cin >> ln;
    for (char c : ln) editor.push_front(c);

    cursor = editor.begin();

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) 
    {
        char command;
        cin >> command;

        switch (command) {
            case 'L':
                if (cursor != editor.end()) cursor++;
                break;
            case 'D':
                if (cursor != editor.begin()) cursor--;
                break;
            case 'B':
                if (cursor != editor.end()) cursor = editor.erase(cursor);
                break;
            case 'P':
                cin >> command;
                cursor = editor.insert(cursor, command);
                break;
        }
    }

    for (auto iter = editor.rbegin(); iter != editor.rend(); iter++)
        cout << *iter;
    // cout << editor.front();
    cout <<'\n';

    return 0;
}