#include <cstdio>
#include <algorithm>
using namespace std;

inline int av(int a, int b) {
    return (a+b)/2;
}

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    int money[N];
    int maximum  = 0;
    for (int i = 0; i < N; ++i) {
        scanf("%d", money+i);
        maximum = max(maximum, money[i]);
    }

    int lb = 0;
    int ub = __INT_MAX__;

    for (int mid = av(lb,ub); ub > lb; mid = av(lb,ub)) {
        if (lb == mid) {
            printf("%d\n", ub);
            break;
        }

        // int count = 0;
        // int withdrawal = 0;
        // for (int i = 0; i < N; ++i) {
        //     if (money[i] <= withdrawal) {
        //         withdrawal -= money[i];
        //     } else {
        //         int target = money[i];
        //         target -= withdrawal;
        //         int r = target / mid;
        //         int toAdd = (target == r*mid ? r : r+1);    
        //         count += toAdd;
        //         withdrawal = mid*toAdd - target;
        //     }
        // }
        // bool fullfilled = count == M;
        int withdrawal[M] = {0,};
        int j = 0;
        int i = 0;
        // fill(withdrawal, withdrawal+M, mid);
        int target = money[i];
        while (i < N && j < M) {
            if (withdrawal[j] + target <= mid) {
                withdrawal[j] += target;
                target = money[++i];
            } else {
                if (target > mid) {
                    j = __INT_MAX__;
                    break;
                }
                withdrawal[++j] = min(mid, target);
                target -= withdrawal[j];
                // if (target != 0) {
                //     j = 0;
                //     break;
                // }
            }
        }

        // printf("count = %d\n", count);
        if (j < M)
            ub = mid;
        else
            lb = mid;

    }

}