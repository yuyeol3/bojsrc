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

    for (long long mid=(ub+lb)/2;ub>lb;mid=(ub+lb)/2) {
        if (lb == mid) {
            printf("%lld\n", ub);
            break;
        }

        long long idx = 0;
        for (long long i = 1; i <= N; ++i) {
            idx += min(mid / i, N);
        }

        if (idx >= K) {
            ub = mid;
        } else {
            lb = mid;
        }
        
    }
    return 0;
}