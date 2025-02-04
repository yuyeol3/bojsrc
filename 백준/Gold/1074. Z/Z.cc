#include <bits/stdc++.h>
using namespace std;

int z(int n, int r, int c) {
    if (n == 0) return 0;
    int n2 = 1 << n;
    int ndiv2 = n2 / 2;
    // int ndiv4 = n2 / 4;
    // int dr = r / 2;
    // int dc = c / 2;
    int pr = (int) r >= ndiv2;
    int pc = (int) c >= ndiv2;

    int coeffs[2][2] = {{0, 1}, {2, 3}};
    int coeff = coeffs[pr][pc];

    return (ndiv2*ndiv2*coeff) + z(n-1, r - pr * ndiv2, c - pc * ndiv2);
}

int main() {
    int N, R, C;
    cin >> N >> R >> C;
    cout << z(N, R, C);
}