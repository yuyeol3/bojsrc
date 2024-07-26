#include <cstdio>
#include <vector>
#define DIV 10007
using namespace std;

vector<vector<int>> combDP;

int comb(int n, int r) {
    if (r > n) return 0;
    if (r == 0) return 1;
    if (n == 1 || n == 0) return 1;
    if (combDP[n][r] != -1) return combDP[n][r];

    int res;
    res = comb(n-1, r-1) % DIV;
    res += comb(n-1, r) % DIV;
    res %= DIV;

    combDP[n][r] = res;
    return combDP[n][r];
}

int main() {
    int N, K;
    scanf("%d %d", &N, &K);
    combDP.resize(N+1, vector<int>(K+1, -1));

    printf("%d\n", comb(N, K));
    return 0;
}