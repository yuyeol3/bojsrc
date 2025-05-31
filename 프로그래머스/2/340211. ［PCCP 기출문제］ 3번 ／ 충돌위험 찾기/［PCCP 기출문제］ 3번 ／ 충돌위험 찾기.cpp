#include <bits/stdc++.h>
using namespace std;

int getD(int x) {
    if (x == 0) return 0;
    else if (x > 0) return 1;
    else if (x < 0) return -1;
}

int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    vector<vector<pair<int, int>>> distances;
    
    // 좌표별 이동거리 계산
    for (int i = 0; i < routes.size(); i++) {
        vector<int> target = routes[i];
        vector<pair<int, int>> distance;
        for (int j = 0; j < target.size() - 1; j++) {
            int x = points[target[j+1]-1][0] - points[target[j]-1][0];
            int y = points[target[j+1]-1][1] - points[target[j]-1][1];
            distance.push_back({x, y});
        }
        distances.push_back(distance);
    }
    
    
    vector<int> moveStat(routes.size(), 0);
    vector<pair<int, int>> coords(routes.size(), {0, 0});
    
    for (int i = 0; i < routes.size(); i++) {
        coords[i].first = points[routes[i][0]-1][0];
        coords[i].second = points[routes[i][0]-1][1];
    }
    
    
    int totMoveCnt = 0;
    int answer = 0;
    while (totMoveCnt < (routes[0].size() - 1) * routes.size()) {
        
        map<pair<int, int>, int> checkOverlap;
        for (int i = 0; i < coords.size(); i++) {
            // 있으면
            if (moveStat[i] >= routes[0].size()) { continue; }
            if (moveStat[i]+1 == routes[0].size()) {
                moveStat[i]++;
            }
            if (checkOverlap.find(coords[i]) != checkOverlap.end()) {
                checkOverlap[coords[i]]++;
            }
            else {
                checkOverlap.insert({coords[i], 0});
            }
        }
        
        for (auto [k, v] : checkOverlap) {
            // cout << v << ' ';
            if (v) answer++;
        }
        // cout << endl;
        
        for (int i = 0; i < routes.size(); i++) {
            if (moveStat[i] >= distances[0].size()) continue;
            int dx = getD(distances[i][moveStat[i]].first);
            int dy = getD(distances[i][moveStat[i]].second);
            
            if (dx == 0) {
                coords[i].second += dy;
                distances[i][moveStat[i]].second -= dy;
            }
            else {
                coords[i].first += dx;
                distances[i][moveStat[i]].first -= dx;
            }
            
            if (!distances[i][moveStat[i]].second && !distances[i][moveStat[i]].first) {
                moveStat[i]++;
                totMoveCnt++;
            }
        }
        
    }

    map<pair<int, int>, int> checkOverlap;
    for (int i = 0; i < coords.size(); i++) {
        // 있으면
        if (moveStat[i] >= routes[0].size()) { continue; }
        if (moveStat[i]+1 == routes[0].size()) {
            moveStat[i]++;
        }
        if (checkOverlap.find(coords[i]) != checkOverlap.end()) {
            checkOverlap[coords[i]]++;
        }
        else {
            checkOverlap.insert({coords[i], 0});
        }
    }

    for (auto [k, v] : checkOverlap) {
        // cout << v << ' ';
        if (v) answer++;
    }
    // cout << endl;
    return answer;
}