#include <cstdio>
#include <unordered_set>
using namespace std;

int main() {
    int N, M;
    scanf("%d", &N);
    unordered_set<int> A;

    int temp;
    for (int i = 0; i < N; ++i) {
        scanf("%d", &temp);
        A.insert(temp);
    }

    scanf("%d", &M);
    for (int i = 0; i < M; ++i) {
        scanf("%d", &temp);
        if (A.find(temp) != A.end())
            printf("1\n");
        else
            printf("0\n");
    }
    return 0;
}