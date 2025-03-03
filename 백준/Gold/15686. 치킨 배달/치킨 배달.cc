#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
#define MAX 2147483647

int maps[51][51];
pair<int, int> house[102], chicken[15];
int N, M, H=0, C=0, NotM;
pair<int, int> selected[14];
int min_dist = MAX;

bool isRemoved(pair<int, int> target) {
    for (int k = 0; k < NotM; k++) 
        if (target.X == selected[k].X && target.Y == selected[k].Y)
            return true;

    return false;
}

void updateMinDist() {
    int thisDist = 0;
    for (int i = 0; i < H; i++) {
        pair<int, int> curH = house[i];
        int curMinDist = MAX;
        for (int j = 0; j < C; j++) {
            pair<int, int> curC = chicken[j];
            if (!isRemoved(curC))  {
                int d = abs(curH.X - curC.X) + abs(curH.Y - curC.Y);
                curMinDist = min(curMinDist, d);
            }
        }
        thisDist += (curMinDist == MAX ? 0 : curMinDist);
    }
    min_dist = min(min_dist, thisDist);
}

void choose(int k, int idx) {
    if (idx == NotM) {
        // for (int i = 0; i < M; i++) {
        //     cout << selected[i].X << "," << selected[i].Y << ' ';
        // }
        // cout << "\n\n";
        updateMinDist();
        return;
    }
    if (k == C) return;

    selected[idx] = chicken[k];
    choose(k+1, idx+1);
    choose(k+1, idx);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> maps[i][j];
            if (maps[i][j] == 1) {
                house[H++] = {i, j};
            }
            else if (maps[i][j] == 2) {
                chicken[C++] = {i, j};
            }
        }
    }
    NotM = C - M;
    choose(0, 0);
    cout << min_dist << '\n';
}