#include <cstdio>
#include <vector>
#include <cmath>
#define FAIL __INT_MAX__ -1
#define RMAX 100001
#define CMAX 317
using namespace std;

int dp[RMAX][CMAX];

inline int sq(int x) {
    return x*x;
}

int f(int k, int num) {
    if (k == 0)                        return 0;
    if (k == sq(num))                  return dp[k][num] = 1;
    if (k < 0 || k < num)              return FAIL;
    if (k < sq(num))                   return FAIL;
    if (num < 0)                       return FAIL;
    if (dp[k][num] == FAIL)            return FAIL;
    if (dp[k][num] != __INT_MAX__)     return dp[k][num];

    int res = FAIL;
    res = min(res, 0 + f( k, num+1 ));
    if (k-sq(num) >= 0) {
        // res = min(res, 1 + f( k-sq(num), num+1 ));
        res = min(res, 1 + f( k-sq(num), num ));
    } 



    dp[k][num] = res >= FAIL ? FAIL : res;
    return dp[k][num];
}


int main(int argc, char **argv) {
    int N;
    scanf("%d", &N);
    // sscanf(argv[1], "%d", &N);
    for (int i = 0; i < RMAX; ++i) {
        for (int j = 0; j < CMAX; ++j) {
            dp[i][j] = __INT_MAX__;
        }
    }
    printf("%d\n", f(N, 1));
    return 0;
}