#include <bits/stdc++.h>
using namespace std;

int num[10];
int res[10];
int N, M;

void f(int k) {
    if (k == M) {
        for (int i = 0; i < M; i++) {
            cout << res[i] << ' ';
        }
        cout << '\n';
        return;
    }   

    int tmp = 0;
    for (int i = 0; i < N; i++) {
        if (
            tmp != num[i]
            && (k == 0 || (k > 0 && res[k-1] <= num[i])) 
            // && 
        ) 
        {
            res[k] = num[i];
            tmp = num[i];
            f(k+1);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++) 
        cin >> num[i];
    sort(num, num+N);
    f(0);
}