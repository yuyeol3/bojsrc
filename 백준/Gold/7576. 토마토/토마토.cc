#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int tomatoes[1002][1002];
int dist[1002][1002];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int m, n;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> m >> n;
    queue<pair<int, int>> q;

    for (int i = 0; i < n; i++)
        fill(dist[i], dist[i] + m, -1);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> tomatoes[i][j];
            if (tomatoes[i][j] == 1) {
                q.push({i,j});
                dist[i][j] = 0;
            }       
        }
    }

    while (!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
            if (tomatoes[nx][ny] == -1 || dist[nx][ny] != -1) continue;
            q.push({nx, ny});
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
        }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (dist[i][j] == -1 && tomatoes[i][j] == 0) {
                cout << -1 << '\n';
                return 0;
            } else {
                if (dist[i][j] > max)
                    max = dist[i][j];
            }       
        }
    }

    cout << max << '\n';
}