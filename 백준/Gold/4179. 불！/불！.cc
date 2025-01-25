#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int maze[1002][1002];
int jMove[1002][1002];
int fMove[1002][1002];

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int R, C;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> R >> C;
    queue<pair<int, int>> jq, fq;

    for (int i = 0; i < R; i++) {
        fill(jMove[i], jMove[i] + C, -1);
        fill(fMove[i], fMove[i] + C, -1);
    }

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            char c;
            cin >> c;
            if (c == '#')
                maze[i][j] = 0;
            else if (c == 'J') {
                maze[i][j] = 1;
                jq.push({i, j});
                jMove[i][j] = 0;
            }
            else if (c == 'F') {
                maze[i][j] = 1;
                fq.push({i, j});
                fMove[i][j] = 0;
            }
            else maze[i][j] = 1;
        }
    }

    // for (int i = 0; i < R; i++) {
    //     for (int j = 0; j < C; j++) {
    //         cout << maze[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    // 불에 대한 bfs
    while (!fq.empty()) {
        pair<int, int> cur = fq.front(); fq.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (maze[nx][ny] == 0 || fMove[nx][ny] != -1) continue;
            fq.push({nx, ny});
            fMove[nx][ny] = fMove[cur.X][cur.Y] + 1;
        }
    }

    // 지훈에 대한 bfs
    while (!jq.empty()) {
        pair<int, int> cur = jq.front(); jq.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (maze[nx][ny] == 0 ||
                jMove[nx][ny] != -1 ||
                (fMove[nx][ny] != -1 && 
                jMove[cur.X][cur.Y] + 1 >= fMove[nx][ny])) 
                { continue; }
            jq.push({nx, ny});
            jMove[nx][ny] = jMove[cur.X][cur.Y] + 1;
        }
    }

    int minimum = __INT32_MAX__;
    // 테두리를 모두 탐색
    for (int i = 0; i < C; i++) {
        if (jMove[0][i] != -1 && minimum > jMove[0][i])
            minimum = jMove[0][i];
        
        if (jMove[R-1][i] != -1 && minimum > jMove[R-1][i])
            minimum = jMove[R-1][i];
    }

    for (int i = 0; i < R; i++) {
        if (jMove[i][0] != -1 && minimum > jMove[i][0])
            minimum = jMove[i][0];
        
        if (jMove[i][C-1] != -1  && minimum > jMove[i][C-1])
            minimum = jMove[i][C-1];
    }

    if (minimum == __INT32_MAX__) cout << "IMPOSSIBLE" <<'\n';
    else  cout << minimum + 1 << '\n';

    // cout << "JIHOON MOVE" << '\n';
    // for (int i = 0; i < R; i++) {
    //     for (int j = 0; j < C; j++) {
    //         cout << jMove[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    // cout << "FIRE MOVE" << '\n';
    // for (int i = 0; i < R; i++) {
    //     for (int j = 0; j < C; j++) {
    //         cout << fMove[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';
}