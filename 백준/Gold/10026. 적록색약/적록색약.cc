#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

const int R = 'R';
const int G = 'G';
const int B = 'B';

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};

char dat[102][102];
bool vis_n[102][102];
bool vis_w[102][102];

struct ColorPixel {
    int x, y, color;
};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < N; j++) {
            dat[i][j] = s[j];
        }
    }

    queue<pair<int, int>> q;
    int ncount = 0;
    // 일반
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!vis_n[i][j]) {
                q.push({i, j});
                vis_n[i][j] = true;
                ncount++;
            }
            
            while (!q.empty()) {
                pair<int, int> cur = q.front(); q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (vis_n[nx][ny] || dat[nx][ny] != dat[cur.X][cur.Y]) continue;
                    q.push({nx, ny});
                    vis_n[nx][ny] = true;
                }
            }
        }
    }

    int wcount = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!vis_w[i][j]) {
                q.push({i, j});
                vis_w[i][j] = true;
                wcount++;
            }
            
            while (!q.empty()) {
                pair<int, int> cur = q.front(); q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (vis_w[nx][ny]) continue;
                    if (dat[nx][ny] != dat[cur.X][cur.Y]) {
                        if (dat[nx][ny] == B || dat[cur.X][cur.Y] == B) 
                            continue;
                    }
                    q.push({nx, ny});
                    vis_w[nx][ny] =  true;
                }
            }
        }
    }

    cout << ncount << ' ' << wcount << '\n';
}