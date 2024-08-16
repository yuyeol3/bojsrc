#include <cstdio>
#include <algorithm>
using namespace std;

struct Rule { int st,ed,step; };
int main() {
    int N, K, D;
    scanf("%d %d %d", &N, &K, &D);
    Rule rules[K];
    for (int i = 0; i < K; ++i) {
        scanf("%d %d %d",&rules[i].st, &rules[i].ed, &rules[i].step);
    }
    int ub = N*2;
    int lb = 0;

    while (ub > lb) {
        int mid = (ub+lb)/2;
        if (lb == mid) {
            printf("%d\n", ub);
            break;
        }

        int leftDotori = D;
        for (int i = 0; i < K && leftDotori > 0; ++i) {
            if (mid >= rules[i].st) {
                leftDotori -= (min(rules[i].ed, mid) - rules[i].st) / rules[i].step + 1;
            }
        }

        if (leftDotori > 0) {
            lb = mid;
        } else {
            ub = mid;
        }
    }
    return 0;
}
