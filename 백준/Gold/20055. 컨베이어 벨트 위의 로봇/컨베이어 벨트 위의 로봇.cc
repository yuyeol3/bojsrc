#include <bits/stdc++.h>
using namespace std;

#define IDX(x) ((2*N - offset + x) % (2*N))

int N, K;
int wear[205];
bool belt[205];

void printArr(bool *arr, int N) {
    for (int i = 0; i < N; i++) {
        cout << arr[i] << ' ';
    }
    cout << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> K;
    for (int i = 0; i < 2*N; i++) {
        cin >> wear[i];
    }

    int step = 0;
    int offset = 0;
    /*
    0 -> 1 -> 2 -> 3 0  (4 + 3 - 0) % 4
    3 -> 0 -> 1 -> 2 1  (4 + 3 - 1) % 4
    2 -> 3 -> 0 -> 1 2  (4 + x - 2) % 4
    1 -> 2 -> 3 -> 0 3
    0 -> 1 -> 2 -> 3 0
    */
    while (true) {
        offset = (offset + 1) % (2*N);
        step++;
        belt[IDX(N-1)] = false;
        for (int i = N-2; i >= 0; i--) {
            if (!belt[IDX(i)]) continue;

            if (!belt[IDX(i+1)] && wear[IDX(i+1)] >= 1) {
                belt[IDX(i)] = false;
                wear[IDX(i+1)]--;
                belt[IDX(i+1)] = (i != N-2);
            }

        }

        if (wear[IDX(0)] >= 1) {
            belt[IDX(0)] = true;
            wear[IDX(0)]--;
        }

        int wear_cnt = 0;
        for (int i = 0; i < 2*N; i++) {
            if (wear[i] == 0) wear_cnt++;
        }
        if (wear_cnt >= K) break;
        // belt[IDX(N-1)] = false;
    }
    cout << step << '\n';
    return 0;
}