#include <cstdio>
#include <algorithm>
using namespace std;

struct Rule {
    int st;
    int ed;
    int step;
};

// functor Cmp for sort
struct Cmp {
    bool operator()(Rule a, Rule b) {
        return a.st < b.st;
    }
};

int main() {
    int N, K, D;
    scanf("%d %d %d", &N, &K, &D);
    Rule rules[K];
    for (int i = 0; i < K; ++i) {
        scanf("%d %d %d",&rules[i].st, &rules[i].ed, &rules[i].step);
    }
    sort(rules, rules+K, Cmp());
    int ub = N + 1;
    int lb = rules[0].st - 1;


    while (ub > lb) {
        int mid = (ub+lb)/2;
        if (lb == mid) {
            printf("%d\n", ub);
            break;
        }

        int leftDotori = D;
        for (int i = 0; i < K && leftDotori > 0; ++i) {
            // mid는 계산하는 규칙의 start보다 크거나 같아야 함
            // mid가 start보다 작은 경우는 도토리가 들어가지 않기 때문
            if (mid >= rules[i].st) {
                leftDotori -= (min(rules[i].ed, mid) - rules[i].st) / rules[i].step + 1;
            }
            
        }
        // printf("mid = %d, leftDotori = %d\n", mid, leftDotori);

        if (leftDotori > 0) {
            lb = mid;
        } else {
            ub = mid;
        }
    }
    return 0;
}