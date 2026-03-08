#include <cstdio>
#include <vector>
#define MIN(x, y) (x > y ? y : x)
using namespace std;
struct TC {
    int L;
    int P;
    int V;
    TC(int l, int p, int v) : L(l), P(p), V(v) {}
};

int main() {
    int L, P, V;
    vector<TC> testcases;
    while (true) {
        scanf("%d %d %d", &L, &P, &V);
        if (!L && !P && !V)
            break;

        testcases.push_back(TC(L, P, V));
    }
    int cnt = 1;
    for (TC t : testcases) {
        int r = t.V / t.P;
        int usableD = r * t.L + MIN(t.V % t.P, t.L);
        printf("Case %d: %d\n", cnt++, usableD);
    }
    return 0;
}