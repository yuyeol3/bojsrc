#include <cstdio>
using namespace std;

int main() {
    int K, N;
    scanf("%d %d", &K, &N);
    int length[K];
    for (int i = 0; i < K; ++i) {
        scanf("%d", length+i);
    }

    unsigned int ub, lb;
    ub = (unsigned int)__INT_MAX__ + 1;
    lb = 1;

    while (ub > lb) {
        unsigned int mid = (ub+lb)/2;
        if (lb == mid) {
            printf("%d\n", lb);
            break;
        }

        int cableCount = 0;
        for (int i = 0; i < K; ++i) {
            cableCount += length[i] / mid;
        } 

        if (cableCount >= N) {
            lb = mid;
        } else {
            ub = mid;
        }
    }
    return 0;
}