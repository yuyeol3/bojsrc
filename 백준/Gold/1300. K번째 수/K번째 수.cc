#include <cstdio>
#include <algorithm>
using namespace std;


int main() {
    long long N, K;
    scanf("%lld", &N);
    scanf("%lld", &K);

    long long ub, lb;
    ub = N*N + 1;
    lb = 0;

    while (ub > lb) {
        long long mid = (ub+lb)/2;
        if (lb == mid) {
            printf("%lld\n", ub);
            break;
        }

        long long idx = 0;
        // O(N) 안에 판별 가능?
        for (long long i = 1; i <= N; ++i) {
            // long long r = min(mid / i, N);
            idx += min(mid / i, N);
        }
        // printf("mid: %lld, idx: %lld\n", mid, idx);

        if (idx >= K) {
            ub = mid;
        } else {
            lb = mid;
        }
        
    }
    return 0;
}