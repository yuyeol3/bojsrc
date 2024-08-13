#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
    int N, C;
    scanf("%d %d", &N, &C);
    int houses[N];

    for (int i = 0; i < N; ++i) {
        scanf("%d", houses+i);
    }
    sort(houses, houses+N);

    int lb, ub;
    ub = houses[N-1] - houses[0] + 1;
    lb = 1;

    // printf("%d\n", ub);

    while (ub > lb) {
        int mid = (ub+lb)/2;
        if (lb == mid) {
            printf("%d\n", lb);
            break;
        }

        int i = 0;
        int j = 1;
        int leftRouter = C - 1;
        while ( j < N && 0 <= leftRouter) {
            if (houses[j] - houses[i] >= mid) {
                --leftRouter;
                i = j;
                j = i + 1;
            } else {
                ++j;
            }
        }

        if (leftRouter > 0) {
            ub = mid;
        } else {
            lb = mid;
        }
    }
    return 0;
}