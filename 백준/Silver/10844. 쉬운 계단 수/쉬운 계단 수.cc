#include <cstdio>
#include <vector>
#define DIV 1000000000
using namespace std;

int main() {
    int N;
    scanf("%d", &N);
    vector<vector<long long>> dp(N+1, vector<long long>(10,0));

    // N = 1인 경우 0을 제외한 1~9까지 9개 사용가능
    fill(dp[1].begin()+1,dp[1].end(),1);
    // dp로 풀기
    for (int i = 2; i <= N; ++i) {
        for (int j = 0; j <= 9; ++j) {
            if (j == 0 || j == 9) {
                dp[i][j] = dp[i-1][!j ? 1 : 8] % DIV;
            }
            else {
                dp[i][j] += dp[i-1][j-1] % DIV;
                dp[i][j] += dp[i-1][j+1] % DIV;
                dp[i][j] %= DIV;
            }
        }
    }

    long long res = 0;
    for (int i = 0; i < 10; ++i) {
        res += dp[N][i] % DIV;
    }
    printf("%lld\n", res % DIV);
    return 0;
}