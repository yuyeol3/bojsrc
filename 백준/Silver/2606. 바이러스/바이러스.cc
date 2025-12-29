#include <bits/stdc++.h>
using namespace std;

vector<int> graph[105];
bool visited[105];
int N, M;
int cnt;

void dfs(int node) {
    for (int adj : graph[node]) {
        if (visited[adj]) continue;
        cnt++;
        visited[adj] = true;
        dfs(adj);
    }
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> M;

    for (int i = 0; i < M; i++) {
        int x, y;
        cin >> x >> y;
           
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    visited[1] = true;
    dfs(1);

    cout << cnt << '\n';
    return 0;
}