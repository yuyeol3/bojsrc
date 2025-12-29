#include <bits/stdc++.h>
using namespace std;

vector<int> graph[105];
bool visited[105];
int N, M;

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


    stack<int> st;
    st.push(1);
    visited[1] = true;
    int cnt = 0;
    while (!st.empty()) {
        int node = st.top(); st.pop();
        
        for (int adj : graph[node]) {
            if (visited[adj]) continue;
            cnt++;
            st.push(adj);
            visited[adj] = true;
        }
    }

    cout << cnt << '\n';
    return 0;
}