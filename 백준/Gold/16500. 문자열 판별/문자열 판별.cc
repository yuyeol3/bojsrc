#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

unordered_set<string> substrs;
int dp[101];
string targetStr;

void preset() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
}
/**
 * ### 시간복잡도
 * - substr에서 가장 긴 문자열의 길이 L
 * - substr의 개수 N
 * - targetStr의 길이 M
 * 
 * check 함수에서 substrs 만큼 비교 => O(N)
 * 각 substr 별로 to_check 문자열과 비교 => O(L)
 * targetStr의 각 자리수별로 계산은 한 번만 일어남 = O(M)
 * => `O(NL * M)`
 */
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
    fill(dp, dp+101, -1);
    if (check(0)) {
        cout << 1 << '\n';
    } else {
        cout << 0 << '\n';
    }

    return 0;
}