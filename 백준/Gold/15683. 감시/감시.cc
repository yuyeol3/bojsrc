#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
/*
백트래킹을 사용

1. 데이터를 입력받음
    - cctv 위치는 따로 저장
2. 백트래킹
    - 각 cctv별로 방향을 0 1 2 3 으로 구분
    - cctv는 최대 8개이므로 시간상 문제 없을듯
3. minUnwatched에 최소값을 저장.
*/

int N, M, CNUM = 0;
int dat[10][10];
pair<int, int> cctvs[101];
int rotations[101];
int minUnwatched = 101;

bool directions[5][4] = {
    // 상 우 하 좌
    {0, 1, 0, 0},
    {0, 1, 0, 1},
    {1, 1, 0, 0},
    {1, 1, 0, 1},
    {1, 1, 1, 1}
};

int checkUnwatched() {
    // directions의 결정된 방향에 따라 사각지대의 개수를 판단.
    int simul[10][10] = {{0,},};
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++) 
            simul[i][j] = dat[i][j];

    // 방향은 어떻게 되어야 할까
    for (int i = 0; i < CNUM; i++) {
        pair<int, int> cctv = cctvs[i];
        int rotation = rotations[i];
        int cctv_type = dat[cctv.X][cctv.Y];

        // 해당 cctv의 좌표로부터 상하좌우 방향으로 
        for (int dir = 0; dir < 4; dir++) {
            bool watchable = directions[cctv_type-1][(dir + rotation)%4];
            if (!watchable) continue;
            
            if (dir == 0) {
                // 위쪽
                for (int j = cctv.X - 1; j >= 0; j--) {
                    // if (j < 0 || j >= N) break;
                    if (simul[j][cctv.Y] > 0 && simul[j][cctv.Y] < 6) continue;
                    else if (simul[j][cctv.Y] == 6) break;
                    else simul[j][cctv.Y] = 10;
                }
            }
            else if (dir == 1) {
                // 오른쪽
                for (int j = cctv.Y + 1; j < M; j++) {
                    if (simul[cctv.X][j] > 0 && simul[cctv.X][j] < 6) continue;
                    else if (simul[cctv.X][j] == 6) break;
                    else simul[cctv.X][j] = 10;
                }
            }
            else if (dir == 2) {
                // 아래쪽
                for (int j = cctv.X + 1; j < N; j++) {
                    // if (j < 0 || j >= N) break;
                    if (simul[j][cctv.Y] > 0 && simul[j][cctv.Y] < 6) continue;
                    else if (simul[j][cctv.Y] == 6) break;
                    else simul[j][cctv.Y] = 10;
                }
            }
            else if (dir == 3) {
                // 왼쪽
                for (int j = cctv.Y - 1; j >= 0; j--) {
                    if (simul[cctv.X][j] > 0 && simul[cctv.X][j] < 6) continue;
                    else if (simul[cctv.X][j] == 6) break;
                    else simul[cctv.X][j] = 10;
                }
            }
        }
    }
    int count = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (simul[i][j] == 0) count++; 
        }
    }

    // // 디버그용 출력
    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < M; j++) {
    //         cout << (simul[i][j] == 10 ? 9 : simul[i][j])  << ' ';
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";


    return count;
}

void f(int idx) {
    if (idx == CNUM) {
        minUnwatched = min(minUnwatched, checkUnwatched());
        return;
    }


    for (int i = 0; i < 4; i++) {
        rotations[idx] = i;
        f(idx+1);
        // 사각지대 크기가 0이면 더 이상 작아질 수 없으므로 출력하고 종료
        if (!minUnwatched) {
            cout << 0 << '\n';
            exit(0);
        }
    }

}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;

    for (int i = 0 ; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> dat[i][j];
            if (dat[i][j] > 0 && dat[i][j] < 6) {
                cctvs[CNUM++] = make_pair(i, j);
            }
        }
    }
    f(0);
    cout << minUnwatched << '\n';
}   

