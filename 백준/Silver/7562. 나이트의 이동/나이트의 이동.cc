#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second


int dx[] = {-1, -2, -1, -2, +1, +2, +1, +2};
int dy[] = {-2, -1, +2, +1, -2, -1, +2, +1};


int main() {

    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {

        int dis[302][302];
        int I;
        pair<int, int> cpos, tpos;

        cin >> I;
        cin >> cpos.X >> cpos.Y;
        cin >> tpos.X >> tpos.Y;

        if (cpos.X == tpos.X && cpos.Y == tpos.Y) {
            cout << 0 << '\n';
            continue;
        }

        for (int i = 0; i < I; i++)
            fill(dis[i], dis[i]+I, -1);

        queue<pair<int, int>> q;
        q.push({cpos.X, cpos.Y});
        dis[cpos.X][cpos.Y] = 0;
        bool found = false;
        while (!q.empty() && !found) {
            pair<int,int> cur = q.front(); q.pop();
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                if (dis[nx][ny] != -1) continue;
                if (nx == tpos.X && ny == tpos.Y) {
                    cout << dis[cur.X][cur.Y] + 1 << '\n';
                    found = true;
                    break;
                }
                q.push({nx, ny});
                dis[nx][ny] = dis[cur.X][cur.Y] + 1;
            }
        }
        // if (!found)
        //     cout << 0 << '\n';
    }

}