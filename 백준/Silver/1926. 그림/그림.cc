#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int paper[505][505];
bool visited[505][505];
int n, m;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int dfs(pair<int, int> start) {
    queue<pair<int, int>> q;
    q.push(start);
    visited[start.X][start.Y] = 1;
    int area = 0;
    while (!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        area++;
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny] || !paper[nx][ny]) continue;
            visited[nx][ny] = 1;
            q.push({nx, ny});
        }
    }

    return area;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> paper[i][j];
        }
    }
    int paintNum = 0;

    int max = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (paper[i][j] && !visited[i][j]) {
                paintNum++;
                int area = dfs({i, j});
                if (max < area) max = area;
            }
        }
    }

    cout << paintNum << '\n';
    cout << max << '\n';
}
