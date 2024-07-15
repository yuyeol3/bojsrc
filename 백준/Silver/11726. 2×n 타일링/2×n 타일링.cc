#include <iostream>
#include <vector>
#define DIV 10007

int f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int prev, pprev;
    prev = 2;
    pprev = 1;
    for (int i = 2; i < n; ++i) {
        int temp = prev;
        prev = ((prev%DIV)+(pprev%DIV))%DIV;
        pprev = temp;
    }
    return prev;
}

int main() { 
    int n;
    scanf("%d", &n);
    printf("%d\n", f(n));
    return 0;
}