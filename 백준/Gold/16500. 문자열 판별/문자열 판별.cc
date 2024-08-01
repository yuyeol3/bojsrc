#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

unordered_set<string> substrs;
vector<int> dp;
string targetStr;

void preset() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
}

bool check(int st_idx) {
    if (st_idx >= targetStr.length())
        return true;

    if (dp[st_idx] != -1)
        return (bool) dp[st_idx];

    string to_check = targetStr.substr(st_idx, targetStr.length() - st_idx);

    for (string substr : substrs) {
        int strlen = substr.length();
        if (to_check.substr(0, strlen) == substr) {
            bool res = check(st_idx + strlen);

            if (res) {
                dp[st_idx] = (int) true;
                return true;
            }
        }
    }

    dp[st_idx] = (int) false;
    return false;
}

int main() {
    preset();
    int N;
    cin >> targetStr;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        string temp;
        cin >> temp;
        substrs.insert(temp);
    }
    dp.resize(targetStr.length()+1, -1);

    if (check(0)) {
        cout << 1 << '\n';
    } else {
        cout << 0 << '\n';
    }

    return 0;
}