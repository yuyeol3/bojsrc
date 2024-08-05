#include <cstdio>
#include <vector>
using namespace std;

bool check(vector<int> &trees, long long sawHeight, long long M) {
    long long summation = 0;
    for (int tree : trees) {
        if (tree > sawHeight)
            summation += ((long long)tree - sawHeight);
    }
    return summation >= M;
}

int main() {
    long long N;
    long long M;
    scanf("%lld %lld", &N, &M);
    vector<int> trees(N);

    int maximum = 0;
    for (int i = 0; i < N; ++i) {
        scanf("%d", &trees[i]);
        maximum = max(maximum, trees[i]);
    }
    long long ub = maximum;
    long long lb = 0;
    long long mid;

    // O(N * log (maximum))
    for (long long mid = (ub+lb)/2;
         ub > lb; mid = (ub+lb)/2) {
        if (mid == lb) {
            printf("%lld\n", mid);
            break;
        }
        else if (check(trees, mid, M)) {
            lb = mid;
        }
        else {
            ub = mid;
        }
    }
    return 0;
}