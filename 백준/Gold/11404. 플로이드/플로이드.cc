#include <bits/stdc++.h>
// #define INFTY (1 << 20)
using namespace std;

int N, M;
int W[105][105];
const int INFTY = 0x3f3f3f3f;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (i == j) W[i][j] = 0;
            else W[i][j] = INFTY;
        }
    }

    for (int i = 0; i < M; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        W[a-1][b-1] = min(W[a-1][b-1], c);
        // W[b-1][a-1] = c;
    }

    // printArr2D(W, N);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                W[j][k] = min(W[j][i] + W[i][k], W[j][k]);
            }
        }
    }

    // printArr2D(W, N);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (W[i][j] >= INFTY) cout << "0 ";
            else cout << W[i][j] << ' ';
            
        }
        cout << '\n';
    }
}