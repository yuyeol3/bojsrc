#include <bits/stdc++.h>
using namespace std;

// int dat[20000];
int dist[200005];


int main() {
    int N, K;
    cin >> N >> K;

    fill(dist, dist+200005, -1);

    queue<int> q;
    q.push(N);
    dist[N] = 0;

    while (!q.empty()) {
        int cur = q.front(); q.pop();
        int nxs[] = {cur + 1, cur - 1, cur * 2};
        for (int i = 0; i < 3; i++) {
            int nx = nxs[i];
            if (nx < 0 || nx >= 200005) continue;
            if (dist[nx] == -1) {
                if (nx == K) {
                    cout << dist[cur] + 1 << '\n';
                    return 0;
                }
                q.push(nx);
                dist[nx] = dist[cur] + 1;
            }
        }
    }
    cout << 0 << '\n';
}