#include <iostream>
using namespace std;

int dp[1005][1005] = {{0}};

int calcLCS(string a, string b) 
{
    int la, lb;
    la = a.length();
    lb = b.length();


    for (int i = 1; i < la + 1; i++) {
        for (int j = 1; j < lb + 1; j++) {
            if (a[i-1] == b[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
            }
        }
    }

    return dp[la][lb];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string a, b;
    cin >> a >> b;
    cout << calcLCS(a, b) << '\n';

    // for (int i = 0; i <= a.size() + 1; i++) {
    //     for (int j = 0; j <= b.size() + 1; j++) {
    //         cout.width(2);
    //         cout << dp[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }

    // calcLCS(arr, 10, 10);
}