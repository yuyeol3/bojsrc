#include <iostream>
#include <string>
#include <list>
using namespace std;

class Editor {
    list<char> &line;
    list<char>::iterator cursor;
    int index;
public:
    Editor(list<char> &newLine)
    : line(newLine)
    {
        index = line.size() -1;
        cursor = --line.end();
    }

    void CursorToRight() {
        // 이미 커서가 맨 마지막에 있음
        if (index == line.size() - 1)
            return;

        else if (index == -1) {
            index++;
            cursor = line.begin();
            return;
        }

        cursor++;
        index++;
    }

    void CursorToLeft() {
        // 이미 커서가 맨 앞에 있음
        if (index == -1)
            return;

        if (index == 0) {
            index--;
            return;
        }

        index--;
        cursor--;
    }

    void DeleteLetter() {
        if (index == -1)
            return;

        line.erase(cursor--);
        index--;

        // if (index == -1)
        //     cursor = line.begin();
        /*
        012 2
        01  1
        0   0
        /   -1
        */
    }

    void AddLetter(char l) {
        if (index == line.size() - 1) {
            line.push_back(l);
            cursor = --line.end();
        }
        else if (index == -1) {
            line.push_front(l);
            cursor = line.begin();
        }
        else {
            cursor = line.insert(++cursor, l);
        }
        index++;
    }
};


void preset() {
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
}


int main() {
    // preset();
    list<char> line;
    string buff;
    cin >> buff;
    
    for (char e : buff)
        line.push_back(e);

    Editor editor(line);

    int N;
    char comm;
    cin >> N;
    for (int i = 0; i < N; ++i) {
        cin >> comm;
        switch (comm) {
            case 'L':
                editor.CursorToLeft();
                break;
            case 'D':
                editor.CursorToRight();
                break;
            case 'B':
                editor.DeleteLetter();
                break;
            case 'P':
                cin >> comm;
                editor.AddLetter(comm);
                break;
        }

        // for (char e : line) {
        //     cout << e;
        // }
        // cout << '\n';
    }

    for (list<char>::iterator iter = line.begin(); iter != line.end(); ++iter) {
        cout << *iter;
    }
    cout << '\n';
    return 0;
}
