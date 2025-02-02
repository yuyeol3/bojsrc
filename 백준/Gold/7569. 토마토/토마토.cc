#include <bits/stdc++.h>
using namespace std;

#define X get<0>
#define Y get<1>
#define Z get<2>

char dat[101][101][101];
int dis[101][101][101];

int dx[] = {1, 0, 0, -1, 0, 0};
int dy[] = {0, 1, 0, 0, -1, 0};
int dz[] = {0, 0, 1, 0, 0, -1};

int M, N, H;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);


    cin >> M >> N >> H;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++)
            fill(dis[i][j], dis[i][j] + M, -1);
    }


    queue<tuple<int, int, int>> q;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                int t;
                cin >> t;
                dat[i][j][k] = (char) t;
                if (dat[i][j][k] == (char) 1) {
                    q.push({i, j, k});
                    dis[i][j][k] = 0;
                }
            }
        }
    }



    while (!q.empty()) {
        tuple<int, int, int> cur = q.front(); q.pop();
        for (int dir = 0; dir < 6; dir++) {
            int nx = X(cur) + dx[dir];
            int ny = Y(cur) + dy[dir];
            int nz = Z(cur) + dz[dir];
            if (nx < 0 || nx >= H ||
                ny < 0 || ny >= N ||
                nz < 0 || nz >= M) continue;
            if (dat[nx][ny][nz] == -1  || dis[nx][ny][nz] != -1) 
                continue;
            q.push({nx, ny, nz});
            dis[nx][ny][nz] = dis[X(cur)][Y(cur)][Z(cur)] + 1;
        }
    }

    int mdist = 0;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (dat[i][j][k] == -1) continue;
                if (dis[i][j][k] == -1) {
                    cout << -1 << '\n';
                    return 0;
                }
                mdist = max(mdist, dis[i][j][k]);
            }
        }
    }

    cout << mdist << '\n';

    return 0;
}