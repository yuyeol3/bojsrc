#include <iostream>
#include <vector>
using namespace std;

inline int av(int lb, int ub) {
    return (lb+ub)/2;
}

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    int lectures[N];
    for (int i = 0; i < N; ++i) {
        scanf("%d", lectures+i);
    }

    int lb, ub;
    lb = 0;
    ub = __INT_MAX__;

    for (int mid = av(lb,ub); ub > lb; mid = av(lb,ub)) {
        if (lb == mid) {
            printf("%d\n", ub);
            break;
        }
        int bluerays[M] = {0,};
        int j = 0;
        for (int i = 0; i < M; ++i) {
            for (; j < N; ++j) {
                if (bluerays[i] + lectures[j] <= mid)
                    bluerays[i] += lectures[j];
                else
                    break;
            }
        }
        if (j >= N)
            ub = mid;
        else
            lb = mid;

    }

    return 0;
}
