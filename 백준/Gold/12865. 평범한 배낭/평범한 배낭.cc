#include <cstdio>
#include <vector>
#define WMAX 100001
#define PMAX 101
using namespace std;

struct product {
    int weight;
    int value;
};

int dp[WMAX][PMAX];
vector<product> prods;

int f(int wei, int idx) {
    if (idx < 0) return 0;
    if (dp[wei][idx] != -1) return dp[wei][idx];

    int res = 0;                 
    res = max(res, f(wei, idx-1));
    if (wei-prods[idx].weight >= 0)
        res = max(res, prods[idx].value + f(wei-prods[idx].weight, idx-1));

    dp[wei][idx] = res;
    return dp[wei][idx];
}

int main() {
    int N, K;
    scanf("%d %d", &N, &K);
    for (int i = 0; i < N; ++i) {
        product pd;
        scanf("%d %d", &pd.weight, &pd.value);
        prods.push_back(pd);
    }

    // dp 배열 초기화
    for (int i = 0; i < K+1; ++i) {
        for (int j = 0; j < N+1; ++j) {
            dp[i][j] = -1;
        }
    }
    printf("%d\n", f(K, N-1));

    return 0;
}