#include <bits/stdc++.h>
using namespace std;

bool isPalindrome(string s) {
    int st = 0;
    int ed = s.length() - 1;
    // cout << s << '\n';
    while (st <= ed) {
        if (s[st++] != s[ed--]) return false;
    }

    return true;
}

bool isSimilarPalindrome(string s, bool d) {
    int st = 0;
    int ed = s.length() - 1;
    int cnt = 0;
    while (st <= ed) {
        if (s[st] != s[ed]) {
            if (d && !cnt && s[st] == s[ed-1]) {
                st++;
                ed -= 2;
            }
            else if (!d && !cnt && s[st+1] == s[ed]) {
                st += 2;
                ed--;
            }
            else return false;
            cnt++;
        }
        else {
            st++;
            ed--;
        }
    }

    return true;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        if (isPalindrome(s)) {
            cout << 0 << '\n';
        } 
        else if (
            isPalindrome(s.substr(1, s.size()-1)) ||
            isPalindrome(s.substr(0, s.size()-1)) ||
            isSimilarPalindrome(s, true) ||
            isSimilarPalindrome(s, false)
        )
        {
            // cout << s.substr(1, s.size()-1) << endl;
            // cout << s.substr(0, s.size()-1) << endl;
            cout << 1 << '\n';
        }
        else {
            cout << 2 << '\n';
        }
    }
}