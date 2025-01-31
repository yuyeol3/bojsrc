#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int dat[51][51] = {{0,},};
        bool vis[51][51] = {{0,},};
        int M, N, K;
        int count = 0;
        queue<pair<int, int>> q;
        cin >> M >> N >> K;

        for (int i = 0; i < K; i++) {
            int x, y;
            cin >> x >> y;
            dat[x][y] = 1;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dat[i][j] && !vis[i][j]) {
                    q.push({i, j});
                    vis[i][j] = 1;
                    count++;
                }

                while (!q.empty()) {
                    pair<int, int> cur = q.front(); q.pop();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                        if (!dat[nx][ny] || vis[nx][ny]) continue;
                        q.push({nx, ny});
                        vis[nx][ny] = 1;
                    }
                }
            }
        }
        cout << count << '\n';
    }    
}
