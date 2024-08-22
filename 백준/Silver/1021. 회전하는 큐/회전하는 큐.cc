#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int main() {
    deque<int> d;

    int N, M;
    scanf("%d %d", &N, &M);
    int toPop[M];

    // 뽑을 원소
    for (int i = 0; i < M; ++i) {
        scanf("%d", &toPop[i]);
    }
    for (int i = 0; i < N; ++i) {
        d.push_back(i+1);
    }


    int count = 0;
    for (const int e : toPop) {
        int s_idx = (find(d.begin(), d.end(), e)) - d.begin();
        int ld, rd;

        ld = s_idx;
        rd = d.size() - s_idx;

        if (ld < rd) {
            for (int i = 0; i < ld; ++i) {
                d.push_back(d.front());
                d.pop_front();
                ++count;
            }
            d.pop_front();
        }
        else {
            for (int i = 0; i < rd; ++i) {
                d.push_front(d.back());
                d.pop_back();
                ++count;
            }
            d.pop_front();
        }

    }
    printf("%d\n", count);
    return 0;
}

