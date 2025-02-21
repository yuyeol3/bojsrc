#include <bits/stdc++.h>
using namespace std;

/*
- 스티커를 어떻게 돌릴지
    - 90도로 돌리는 것 하나만 구현하면 모두 구현가능
- 스티커를 붙였을 때의 

*/




/**
 * r : 원래 행 개수
 * c : 원래 열 개수
 */
void rotate90(bool src[][11], int &r, int &c) {
    // r -> c
    // c -> r
    bool tmp[11][11];

    // 회전시키기
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            tmp[j][r-i-1] = src[i][j];
        }
    }

    // 원래 배열에 복사
    for (int i = 0; i < c; i++) {
        for (int j = 0; j < r; j++) {
            src[i][j] = tmp[i][j];
        }
    }

    // r과 c를 바꿈
    swap(r, c);
}

int N, M, K;
bool notebook[41][41];
bool sticker[11][11];

inline bool OOB(int a, int b) {
    return (a < 0 || a >= N || b < 0 || b >= N);
}

bool tryApply(int x, int y, int r, int c, int &tot) {
    for (int i = x; i < x + r; i++) {
        for (int j = y; j < y + c; j++) {
            if ((int) notebook[i][j] + (int) sticker[i-x][j-y] > 1)
                return false;
        }
    }
    for (int i = x; i < x + r; i++) {
        for (int j = y; j < y + c; j++) {
            if (sticker[i-x][j-y]) {
                notebook[i][j] = sticker[i-x][j-y];
                tot++;
            } 
        }
    }

    return true;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> M >> K;

    int tot = 0;
    for (int _ = 0; _ < K; _++) {
        int R, C;
        cin >> R >> C;

        // 스티커 입력받음
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cin >> sticker[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            
            bool found = false;
            for (int j = 0; j <= N-R; j++) {
                for (int k = 0; k <= M-C; k++) {
                    if (tryApply(j, k, R, C, tot)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (found) break;
            rotate90(sticker, R, C);
        }

        // 0 -> 90 -> 180 -> 270

        // // 디버그용 출력
        // for (int i = 0; i < R; i++) {
        //     for (int j = 0; j < C; j++) {
        //         cout << sticker[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
    }

    // // 디버그용 출력
    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < M; j++) {
    //         cout << notebook[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }

    cout << tot << '\n';
}