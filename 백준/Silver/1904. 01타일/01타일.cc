#include <iostream>
#include <vector>
#define DIV 15746
using namespace std;
vector<int> dp;


int f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (dp[n] != -1) return dp[n];


    return dp[n] = ((f(n-1) % DIV) + (f(n-2) % DIV)) % DIV;
}

int main() {
    int n;
    scanf("%d", &n);
    dp.resize(n+1, -1);
    printf("%d\n", f(n));
    return 0;
}