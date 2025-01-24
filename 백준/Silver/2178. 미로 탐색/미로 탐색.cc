#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int dist[102][102];
int maze[102][102];
int n, m;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < m; j++) {
            maze[i][j] = input[j] - '0';
        }
    }

    for (int i = 0; i < n; i++)
        fill(dist[i], dist[i] + m, -1);


    queue<pair<int, int>> q;
    q.push({0, 0});
    dist[0][0] = 0;

    while (!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (maze[nx][ny] == 0 || dist[nx][ny] != -1) continue;
            q.push({nx, ny});
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
        }
    }
    cout << dist[n-1][m-1] + 1 << '\n';
}