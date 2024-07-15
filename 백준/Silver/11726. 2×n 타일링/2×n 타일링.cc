#include <iostream>
#include <vector>
#define DIV 10007


int f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    
    std::vector<int> dp(n+1, -1);
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 2; i < n; ++i) {
        dp[i+1] = ((dp[i]%DIV)+(dp[i-1]%DIV))%DIV;
    }
    return dp[n];
}

int main() { 
    int n;
    scanf("%d", &n);
    printf("%d\n", f(n));
    return 0;
}