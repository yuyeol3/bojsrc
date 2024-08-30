#include <list>
#include <iostream>
using namespace std;

void preset() {
    iostream::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
}

int main() {
    preset();
    string buff;
    int N;

    cin >> N;
    
    for (int i = 0; i < N; ++i) {
        cin >> buff;
        list<char> password;
        list<char>::iterator iter;
        int location = -1;
        for (char c : buff) {
            switch (c) {
                case '<':
                    if (location == -1)
                        break;

                    if (location == 0) {
                        location--;
                        break;
                    }
                    location--;
                    iter--;
                    break;
                case '>':
                    if (location == password.size() - 1)
                        break;

                    if (location == -1)
                        iter = password.begin();
                    else
                        iter++;

                    location++;
                    break;
                case '-':
                    if (location != -1) {
                        password.erase(iter--);
                        location--;
                        if (location == -1)
                            iter = password.begin();
                    }
                    break;
                default:
                    if (location == -1) {
                        password.push_front(c);
                        iter = password.begin();
                    }
                    else if (location == password.size() -1) {
                        password.push_back(c);
                        iter = --password.end();
                    }
                    else {
                        iter = password.insert(++iter, c);                        
                    }
                    location++;
                    break;
            }
        }

        for (char c : password)
            cout << c;
        cout << '\n';
    }

    return 0;
}