#include <cstdio>
#include <vector>
using namespace std;

struct Arr {
    int *arr;
    int length;
};

bool check(Arr &trees, int sawHeight, int M) {
    long long summation = 0;
    for (int i = 0; i < trees.length; ++i) {
        if (trees.arr[i] > sawHeight)
            summation += (long long) (trees.arr[i] - sawHeight);
    }
    return summation >= M;
}

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    int trees[N];
    Arr tr = {trees, N};
    int maximum = 0;
    for (int i = 0; i < N; ++i) {
        scanf("%d", &trees[i]);
        maximum = max(maximum, trees[i]);
    }
    int ub = maximum;
    int lb = 0;
    // O(N * log (maximum))
    for (int mid = (ub+lb)/2;
         ub > lb; mid = (ub+lb)/2) {
        if (mid == lb) {
            printf("%d\n", mid);
            break;
        }
        else if (check(tr, mid, M)) {
            lb = mid;
        }
        else {
            ub = mid;
        }
    }
    return 0;
}