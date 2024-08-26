#include <cstdio>
#include <list>
using namespace std;

inline void iterIncrement(list<int> &p, list<int>::iterator &iter) {
    if (iter == --p.end())  iter = p.begin();
    else ++iter;
}

int main() {
    int N, K;
    scanf("%d %d", &N, &K);

    list<int> p;
    for (int i = 1; i <= N; ++i) {
        p.push_back(i);
    }

    list<int>::iterator iter = p.begin();
    printf("<");
    for (int i = 0; i < N; ++i) {

        for (int j = 0; j < K-1; ++j)
            iterIncrement(p, iter);

        const char *format = (i == N-1 ? "%d>\n" : "%d, ");
        printf(format, *iter);
        list<int>::iterator toDelete = iter;
        iterIncrement(p, iter);
        p.erase(toDelete);
    }

    return 0;
}