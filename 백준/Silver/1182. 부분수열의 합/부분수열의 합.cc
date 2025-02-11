// 부분집합의 개수 2^N
// 진부분집합의 개수 2^N - 1 (공집합 제외)
#include <bits/stdc++.h>
using namespace std;

int N, S, cnt;
int dat[20];

void f(int idx, int sum) {
    if (idx == N) {
        cnt += (sum == S ? 1 : 0);
        return;
    }

    f(idx+1, sum + dat[idx]);
    f(idx+1, sum);
}

int main() {
    cin >> N >> S;
    for (int i = 0; i < N; i++) {
        cin >> dat[i];
    }
    f(0, 0);
    cout << (S == 0 ? cnt - 1 : cnt) << '\n';
}