#include <bits/stdc++.h>
using namespace std;

// bool dat[15][15];
bool isused1[15];
bool isused2[30];
bool isused3[30];
int cnt = 0;
int N;

void f(int n) {
    if (n == N) {
        cnt++;
        return;
    }


    for (int j = 0; j < N; j++) {
        if (!(isused1[j] || isused2[n+j] || isused3[n-j+N-1])) {
            // cout << "inside if: " << n << ' ' << j << ' ' << n << '\n';
            isused1[j] = 1;
            isused2[n+j] = 1;
            isused3[n-j+N-1] = 1;
            f(n+1);
            isused1[j] = 0;
            isused2[n+j] = 0;
            isused3[n-j+N-1] = 0;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N;
    f(0);
    cout << cnt << '\n';
    return 0;
}