#include <cstdio>
#include <vector>
#include <deque>
using namespace std;

typedef vector<vector<int>> vvi;
typedef vector<int>         vi;

int N;
vvi stickers;
vvi dp;

int calcMaxScore(int col, int status) {
    if (col > N) return 0;
    if (dp[col][status] != -1) return dp[col][status];

    // 위의 것을 떼어낼 경우
    int res = calcMaxScore(col+1, 0);
    if (status != 1)
        res = max(res, calcMaxScore(col+1, 1)+stickers[0][col]);
    
    if (status != 2)
        res = max(res, calcMaxScore(col+1, 2)+stickers[1][col]);

    dp[col][status] = res;

    return res;
}

int main() {
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &N);
        stickers.clear();
        stickers.resize(2, vi(N+1, 0));
        dp.clear();
        dp.resize(N+1, vi(3, -1));
        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < N; ++k) {
                scanf("%d", &stickers[j][k]);
            }
        }
        printf("%d\n", calcMaxScore(0, 0));

    }

    return 0;
}