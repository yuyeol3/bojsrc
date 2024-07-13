#include <iostream>
#include <vector>
#define DIV 15746
using namespace std;



int f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int prev  = 2;
    int pprev = 1;

    for (int i = 2; i < n; ++i) {
        int temp = prev;
        prev = ((pprev % DIV) + (prev % DIV)) % DIV;
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