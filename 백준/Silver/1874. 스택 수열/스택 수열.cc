#include <bits/stdc++.h>
using namespace std;

/*
+
-
+
-
+
+
+
-

1. 다음 수가 지금보다 크다
    + 한 뒤 -

2. 다음 수가 지금보다 작다
    그냥 -한다.
*/

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    int series[N];
    for (int i = 0; i < N; i++) {
        cin >> series[i];
    }

    int prev = 0;
    int num = 1;
    stack<int> s;
    stringstream ss;
    ss.tie(0);
    for (int e : series) {
        // 이전보다 큰 경우
        if (e > prev) {
            while (num < e) {
                s.push(num++);
                ss << '+' << '\n';
            }
            num++;
            ss << '+' << '\n';
            ss << '-' << '\n';
        }
        // 작은 경우
        else {
            if (s.top() != e) {
                cout << "NO\n";
                return 0;
            }
            ss << '-' << '\n';
            s.pop();
        }

        prev = e;
    }

    cout << ss.str();
    return 0;
}