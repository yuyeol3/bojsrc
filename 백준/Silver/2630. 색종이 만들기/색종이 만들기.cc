#include <bits/stdc++.h>
using namespace std;

#define B first
#define W second

bool dat[129][129];
using pr = pair<int, int>;

pr f(int n, int r, int c) {
    // base case
    if (n == 1)
        return (dat[r][c] ? 
            pr(1, 0) :
            pr(0, 1)
        );

    /*
    네 구간으로 나눴을 때의 결과가
    IF 모두 같은 색 -> 큰 색종이 1개로 간주
    ELSE 단순히 결과를 더함
    */
    int half = n/2;
    pr x = f(half, r, c);
    pr y = f(half, r, c+half);
    pr z = f(half, r+half, c);
    pr w = f(half, r+half, c+half);

    if (x.B == 1 && y.B == 1 && z.B == 1 && w.B == 1 && 
        x.W == 0 && y.W == 0 && z.W == 0 && w.W == 0) 
    {
        return pr(1, 0);
    }
    else if (x.W == 1 && y.W == 1 && z.W == 1 && w.W == 1 && 
            x.B == 0 && y.B == 0 && z.B == 0 && w.B == 0)
    {
        return pr(0, 1);
    }
    else {
        return pr(
            x.B + y.B + z.B + w.B,
            x.W + y.W + z.W + w.W
        );
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> dat[i][j];
        }
    }

    pr res = f(N, 0, 0);
    cout << res.W << '\n' << res.B << '\n';
}

/*



*/