#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int main() {
    // ios_base::sync_with_stdio(0);
    // cin.tie(0); cout.tie(0);

    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int w, h;
        cin >> w >> h;
        int dat[h][w] = {{0,},};
        int fdis[h][w];
        int sdis[h][w];

        for (int i = 0; i < h; i++) {
            fill(dat[i], dat[i]+w, 0);
            fill(fdis[i], fdis[i]+w, -1);
            fill(sdis[i], sdis[i]+w, -1);
        }
        
        queue<pair<int, int>> fq, sq;

        for (int i = 0; i < h; i++) {
            string ln;
            cin >> ln;
            for (int j = 0; j < w; j++) {
                if (ln[j] == '#') 
                    dat[i][j] = -1;
                else if (ln[j] == '*') {
                    fq.push({i, j});
                    fdis[i][j] = 0;
                }
                else if (ln[j] == '@') {
                    sq.push({i, j});
                    sdis[i][j] = 0;
                }
            }
        }
        
        // 불 전파
        while (!fq.empty()) {
            pair<int, int> cur = fq.front(); fq.pop();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (dat[nx][ny] == -1 || fdis[nx][ny] != -1) continue;
                fq.push({nx, ny});
                fdis[nx][ny] = fdis[cur.X][cur.Y] + 1;
            }
        }

        bool found = false;
        while (!sq.empty() && !found) {
            pair<int, int> cur = sq.front(); sq.pop();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    cout << sdis[cur.X][cur.Y] + 1 << '\n';
                    found = true;
                    break;
                }
                if (dat[nx][ny] == -1 || sdis[nx][ny] != -1 || 
                    (fdis[nx][ny] != -1 && sdis[cur.X][cur.Y] + 1 >= fdis[nx][ny]))
                    continue;
                
                sq.push({nx, ny});
                sdis[nx][ny] = sdis[cur.X][cur.Y] + 1;
            }
        }
        if (!found)
            cout << "IMPOSSIBLE" << '\n';

        // for (int i = 0; i < h; i++) {
        //     for (int j = 0; j < w; j++) {
        //         cout << dat[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';


        // for (int i = 0; i < h; i++) {
        //     for (int j = 0; j < w; j++) {
        //         cout << fdis[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';

        // for (int i = 0; i < h; i++) {
        //     for (int j = 0; j < w; j++) {
        //         cout << sdis[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';
    }
}