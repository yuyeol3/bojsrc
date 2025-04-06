#include <bits/stdc++.h>
using namespace std;

// \binom a b (a >= b)
int binom(int a, int b) {
    if (!a && !b) return 1;

    int arr[a+1][a+1];
    for (int i = 0; i < a+1; i++)
        fill(arr[i], arr[i]+a+1, 0);

    // printArr2D(arr, a+1, a+1);

    arr[0][0] = arr[1][0] = arr[1][1] = 1;
    for (int i = 2; i <= a; i++) {
        for (int j = 0; j <= i; j++) {
            arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
        }
    }

    return arr[a][b];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N, K;
    cin >> N >> K;
    cout << binom(N,K) << '\n';
    return 0;
}