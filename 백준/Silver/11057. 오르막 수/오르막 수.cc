#include <cstdio>
#include <vector>
#define DIV 10007
using namespace std;

vector<vector<long long>> dp;

long long ascendentNum(int n, int k) {
    if (n == 1) return 1;
    if (dp[n][k] != -1) return dp[n][k];

    long long res = 0;
    for (int i = k; i < 10; ++i) {
        res += ascendentNum(n-1, i) % DIV;
    }

    dp[n][k] = res % DIV;
    return dp[n][k];
}

int main() {
    int N;
    scanf("%d", &N);
    dp.resize(N+1, vector<long long>(10, -1));

    long long res = 0;
    for (int i = 0; i < 10; ++i) {
        res += ascendentNum(N, i) % DIV;
    }
    printf("%lld\n", res%DIV);

    return 0;
}