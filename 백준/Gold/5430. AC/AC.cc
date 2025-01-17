#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        deque<int> dq;
        string command;
        int length;
        bool isReversed = false, errorFound = false;
        cin >> command >> length;


        char temp;
        cin >> temp;
        for (int i = 0; i < length; i++) {
            int t;
            cin >> t;

            if (i < length - 1) cin >> temp;

            dq.push_back(t);
        }
        cin >> temp;

        for (char c : command) {
            if (c == 'R') {
                isReversed = !isReversed;
            }
            else if (c == 'D') {
                if (dq.empty()) {
                    cout << "error" << '\n';
                    errorFound = true;
                    break;
                }

                if (isReversed) {
                    dq.pop_back();
                }
                else {
                    dq.pop_front();
                }
            }
        }

        if (!dq.empty()) {
            if (isReversed) {
                cout << "[";
                for (int i = (int) dq.size() - 1; i >=0; i--) {
                    cout << dq[i] << (i > 0 ? "," : "");
                }
                cout << "]\n";
            }
            else {
                cout << "[";
                for (int i = 0; i < (int) dq.size(); i++) {
                    cout << dq[i] << (i < (int) dq.size() - 1 ? "," : "");
                }
                cout << "]\n";
            }
        }
        else if (dq.empty() && !errorFound) {
            cout << "[]\n";
        }
    }
    return 0;
}