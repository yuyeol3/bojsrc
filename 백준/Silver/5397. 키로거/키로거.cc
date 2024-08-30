#include <list>
#include <iostream>
using namespace std;

void preset() {
    iostream::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
}

/**
 * 1. index = -1
 * 2. 0 <= index < password.size() -1
 * 3. index = password.size() -1
 */

int main() {
    preset();
    // vector<char> input;
    string buff;
    int N;

    cin >> N;
    
    for (int i = 0; i < N; ++i) {
        cin >> buff;
        // for (char e : buff)
        //     input.push_back(e);
        list<char> password;
        list<char>::iterator iter;
        int location = -1;
        for (char c : buff) {
            switch (c) {
                case '<':
                    // if (location != -1) {
                    //     if ()

                    //     location--;
                    // }

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
                    // if (location != password.size() - 1) {
                    //     if (location == -1) {
                    //         iter = password.begin();
                    //     }
                    //     location++;
                    // }
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
        password.clear();
    }

    return 0;
}