#include <iostream>
#include <vector>
#define DIV 10007

std::vector<int> dp;

int f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 3;
    if (dp[n] != -1) return dp[n];
    
    dp[n] = (f(n-2)%DIV + f(n-2)%DIV + f(n-1)%DIV)%DIV;
    return dp[n];
}

int main() {
    int n;
    scanf("%d", &n);
    dp.resize(n+1, -1);
    printf("%d\n", f(n));
    return 0;
}
