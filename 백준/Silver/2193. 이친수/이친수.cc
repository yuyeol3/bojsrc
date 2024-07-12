#include <iostream>
#include <vector>
using namespace std;

vector<long long> dp;

long long f(int n) {
    if (n <= 0) return 0; 
    if (n == 1) return 1;
    if (dp[n] != -1) return dp[n];

    long long res = 1;
    for (int i = 1; i < n -1; ++i) {
        res += f(i);
    }
    dp[n] = res;
    return res;
}

int main() {
    int n;
    scanf("%d", &n);
    dp.resize(n+1, -1);
    printf("%lld\n", f(n));
    return 0;
}