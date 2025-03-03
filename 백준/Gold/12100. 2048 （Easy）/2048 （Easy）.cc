#include <bits/stdc++.h>
using namespace std;

#define UP 1
#define DOWN 0
#define LEFT 3
#define RIGHT 2

using ll = long long;

int N;
ll board[21][21];

void move(int dir, ll dat[][21]) {
    /*
        위 : 열 방향으로 아래부터 훑기
        아래 : 열 방향, 위부터
        좌 : 행 방향 오른쪽부터
        우 : 행 방향 왼쪽부터
    */
    int moves[4][5] {
      // {x, y, dx, dy, rev}  
      {0, 0, 1, 1, 1}, // 상
      {N-1, 0, -1, 1, 1},  // 하
      {0, 0, 1, 1, 0}, // 좌
      {0, N-1, 1, -1, 0} // 우
    };

    int x = moves[dir][0];
    int y = moves[dir][1];
    int *coords[2] = {&x, &y};
    int rev = moves[dir][4];
    for (int i = 0; i < N; i++) {
        deque<pair<ll, bool>> st;
        for (int j = 0; j < N; j++) {
            // cout << '(' << x << ',' << y << ')' << '\n';            
            if (dat[x][y]) {  // dat[x][y] 가 0이 아닌 경우
                // if (st.empty() || st.back().first != dat[x][y])
                    
                
                if (!st.empty() && st.back().first == dat[x][y] && !(st.back().second)) {
                    st.pop_back();
                    st.push_back({2 * dat[x][y], true});
                }
                else st.push_back({dat[x][y], false});

            }
            *coords[!rev] += moves[dir][3 - rev];
        }


        // *coords[!rev] = moves[dir][!rev] == 0 ? N-1 : 0;
        *coords[!rev] = moves[dir][!rev];
        for (int j = 0; j < N; j++) {
            if (st.empty()) {
                dat[x][y] = 0;
            }
            else {
                dat[x][y] = st.front().first;
                st.pop_front();
                
            }   
            *coords[!rev] += moves[dir][3 - rev];
        }


        *coords[!rev] = moves[dir][!rev];
        *coords[rev] += moves[dir][2 + rev];
    }


    // // 디버그용 출력
    // for (int a = 0; a < N; a++) {
    //     for (int b = 0; b < N; b++) {
    //         // cout << dat[a][b] << ' ';
    //         printf("%4d ", dat[a][b]);
    //     }
    //     cout << "\n";
    // }
    // cout << "---------------\n";

}

ll solve(int dirs[]) {

    // // 디버그용 출력
    // cout << "Case: ";
    // for (int i = 0; i < 5; i++) {
    //     cout << dirs[i] << ' ';
    // }
    // cout << '\n';

    ll tmpBoard[21][21];
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < N; j++) 
            tmpBoard[i][j] = board[i][j];

    for (int i = 0; i < 5; i++) {
        move(dirs[i], tmpBoard);
    }

    ll maximum = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            maximum = max(maximum, tmpBoard[i][j]);
        }
    }
    return maximum;

}

int main() {
    // ios_base::sync_with_stdio(0);
    // cin.tie(0); cout.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    ll maximum = 0;
    int SP = 1 << 10;
    // 모든 경우의 수 구하기
    for (int i = 0; i < SP; i++) {
        int nums[5] = {0,};
        int tmp = i;
        for (int j = 0; j < 5; j++) {
            nums[j] = tmp % 4;
            tmp /= 4;
        }

        maximum = max(maximum, solve(nums));
    }
    // N = 2;
    // move(RIGHT);
    cout << maximum << '\n';
    return 0;
}