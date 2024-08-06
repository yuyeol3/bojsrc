#include <cstdio>
#include <vector>
using namespace std;

int main() {
    int N, budget, maximum;
    scanf("%d", &N);
    int locals[N];

    maximum = 0;
    for (int i = 0; i < N; ++i) {
        scanf("%d", locals+i);
        maximum = maximum > locals[i] ? maximum : locals[i];
    }
    scanf("%d", &budget);

    int ub, lb;
    ub = maximum + 1;
    lb = 0;
    for (int mid = (ub+lb)/2; ub>lb; mid = (ub+lb)/2) {
        if (mid == lb) {
            printf("%d\n", mid);
            break;
        }
        int summation = 0;
        for (int i = 0; i < N; ++i) {
            summation += (mid >= locals[i] ? locals[i] : mid);
        }
        if (summation > budget) {
            ub = mid;
        } else {
            lb = mid;
        }
    }
    return 0;
}