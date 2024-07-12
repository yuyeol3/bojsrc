#include <iostream>
#include <vector>
#define MAX 1000001
using namespace std;

int memo[MAX];

int getMinCalc(int n) {
    if (n == 1) return 0;
    if (memo[n] != -1) return memo[n];

    int result = getMinCalc(n - 1) + 1;
    if (!(n % 2))
        result = min(result, getMinCalc(n / 2) + 1);
    if (!(n % 3))
        result = min(result, getMinCalc(n / 3) + 1);
    
    memo[n] = result;
    return result;
}


int main() {
    int n;
    scanf("%d", &n);
    fill(memo, memo+MAX, -1);
    printf("%d\n", getMinCalc(n));
    return 0;
}