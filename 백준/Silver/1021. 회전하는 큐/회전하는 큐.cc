#include <iostream>
#include <deque>
using namespace std;

int search(deque<int> &dq, int toSearch) {
    for (int i = 0; i < dq.size(); ++i) {
        if (dq[i] == toSearch)
            return i;
    }
}

void printDeque(deque<int> &dq) {
    for (int i = 0; i < dq.size(); ++i) {
        printf("%d ", dq[i]);
    }
    printf("\n");
}

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
        int s_idx = search(d, e);
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