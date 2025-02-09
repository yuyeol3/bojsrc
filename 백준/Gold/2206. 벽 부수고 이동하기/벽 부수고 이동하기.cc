#include <bits/stdc++.h>
using namespace std;

#define X get<0>
#define Y get<1>
#define B get<2>

/*
처음 생각 :
    큐에 원소들을 넣고
    부쉈는지 유무를 표시해서
    방문 방지 조건에 추가하면
    풀릴 것이라고 생각

visit을 여러개 만들기?


일단 dfs 하다가 막히면?
칸을 옮기기?

그럴 경우 문제점은 
이미 방문한 곳으로 돌아갈 수 있다. 
[0] || [n]th

공간을 너무 많이 차지함

조금 더 최적화할 수 있는 방법?

'최단 거리'
- 대각선으로 움직이지 못한다는 점
- 위나 왼쪽 방향의 벽을 뚫을 이유가 없지 않나
- 한 번 뚫린 뒤에는 또 뚫을 수는 없다

1들을 queue에 넣는다고 가정하면
아직 부수지 않은 경우 큐에 넣고
부순 경우 넣지 않는 방식으로 한다

이렇게 하면 dis 배열에서 문제가 발생

'만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면,'
'벽을 한 개 까지 부수고 이동하여도 된다.'

벽을 부수고 이동하는 것이 경로가 짧아진다면의 조건을 찾아보자


큐에 담고 난 뒤


00000
11110
00000
01111
00000
11110
00000

11


*/

const int MAX = 1000 * 1000;

int dat[1001][1001];
int dis[1001][1001][2];

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);


    int N, M;
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        string ln;
        cin >> ln;
        for (int j = 0; j < M; j++) {
            dat[i][j] = ln[j] - '0';
        }
    }

    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            fill(dis[i][j], dis[i][j]+2, -1);

    queue<tuple<int, int, bool>> q;
    q.push(make_tuple(0, 0, false));
    dis[0][0][0] = 0;
    dis[0][0][1] = 0;

    while (!q.empty()) {
        tuple<int, int, bool> cur = q.front(); q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = X(cur) + dx[dir];
            int ny = Y(cur) + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            // if (dis[nx][ny] != -1 || dat[nx][ny] == 1) continue
            if ((!B(cur) && dis[nx][ny][0] != -1 ) || 
                (B(cur) && (dis[nx][ny][1] != -1 || dat[nx][ny] == 1))) 
                continue;
            
            if (dat[nx][ny] == 1) {
                q.push(make_tuple(nx, ny, true));
                dis[nx][ny][1] = dis[X(cur)][Y(cur)][0] + 1;
            }
            else {
                q.push(make_tuple(nx, ny, B(cur)));
                if (!B(cur)) {
                    dis[nx][ny][0] = dis[X(cur)][Y(cur)][0] + 1;
                    // dis[nx][ny][1] = dis[X(cur)][Y(cur)][0] + 1;
                }
                else {
                    dis[nx][ny][1] = dis[X(cur)][Y(cur)][1] + 1;
                }
            }
        }
    }

    int res = min(dis[N-1][M-1][0] == -1 ? MAX : dis[N-1][M-1][0] , 
                 dis[N-1][M-1][1] == -1 ? MAX : dis[N-1][M-1][1]);

    cout << (res == MAX ? -1 : res+1) << '\n';
    return 0;
}
/*

0000
1110
0000
0111
0000

0000
0000
0011
0010

0010


*/