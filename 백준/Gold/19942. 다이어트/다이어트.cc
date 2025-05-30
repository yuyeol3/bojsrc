#include <bits/stdc++.h>
using namespace std;

struct ingredient {
    int protein;
    int fat;
    int starch;
    int vitamin;
    int cost;

    ingredient operator+(const ingredient &rhs) {
        ingredient toReturn;
        toReturn.protein = protein + rhs.protein;
        toReturn.fat = fat + rhs.fat;
        toReturn.starch = starch + rhs.starch;
        toReturn.vitamin = vitamin + rhs.vitamin;
        toReturn.cost = cost + rhs.cost;
        return toReturn;
    }

    ingredient operator-(const ingredient &rhs) {
        ingredient toReturn;
        toReturn.protein = protein - rhs.protein;
        toReturn.fat = fat - rhs.fat;
        toReturn.starch = starch - rhs.starch;
        toReturn.vitamin = vitamin - rhs.vitamin;
        toReturn.cost = cost - rhs.cost;
        return toReturn;
    }


    int getSum() {
        return (protein + fat + starch + vitamin);
    }

}; // 20 bytes;
int N;
ingredient ingredients[51];
ingredient rIngridient; // 필요한 영양소

int min_cost = INT_MAX;
int selected[51];
ingredient val;
pair<vector<int>, ingredient> result;

void calcComb(int i, int k) {
    
    if (i > N) return;
    if (val.cost > min_cost) return;
    
    ingredient t = val;
    for (int it = i; it < N; it++) {
        t = t + ingredients[it];
    }

    if (t.fat < rIngridient.fat ||
        t.protein < rIngridient.protein ||
        t.starch < rIngridient.starch || 
        t.vitamin < rIngridient.vitamin) 
        return;

    if (val.fat >= rIngridient.fat &&
        val.protein >= rIngridient.protein &&
        val.starch >= rIngridient.starch &&
        val.vitamin >= rIngridient.vitamin) {
            vector<int> combVec;
            // printf("i : %d, k : %d, cost : %d\n", i, k, val.cost);
            for (int it = 0; it < k; it++) {
                combVec.push_back(selected[it]+1);
            }

            if (val.cost < min_cost) {
                result.first = combVec;
                result.second = val;
                min_cost = val.cost;
            }
            else if (val.cost == min_cost) {
                    if (result.first > combVec) {
                        result.first = combVec;
                        result.second = val;
                    }
            }

            return;
    }

    selected[k] = i;
    val = val + ingredients[i];
    calcComb(i+1, k+1);
    val = val - ingredients[i];
    calcComb(i+1, k);
}

int main() {

    cin >> N;
    cin >> rIngridient.protein >> rIngridient.fat
        >> rIngridient.starch >> rIngridient.vitamin;

    ingredient t = {0, 0, 0, 0, 0};
    for (int i = 0; i < N; i++) {
        cin >> ingredients[i].protein >> ingredients[i].fat
            >> ingredients[i].starch >> ingredients[i].vitamin
            >> ingredients[i].cost;

        t = t + ingredients[i];
    }
    if (t.protein < rIngridient.protein || t.fat < rIngridient.fat || t.starch < rIngridient.starch || t.vitamin < rIngridient.vitamin) {
        cout << -1 << '\n';
        return 0;
    }

    // // greedy approch
    // priority_queue<pair<int, int>> pq;
    // for (int i = 0; i < N; i++) {
    //     pq.push({-1 * ingredients[i].getSum(), i});
    // }

    // t = {0, 0, 0, 0, 0};
    // while (!pq.empty()) {
    //     if (t.fat >= rIngridient.fat &&
    //     t.protein >= rIngridient.protein &&
    //     t.starch >= rIngridient.starch &&
    //     t.vitamin >= rIngridient.vitamin) {
    //         min_cost = t.cost;
    //         break;
    //     }
    //     t = t + ingredients[pq.top().second];
    //     pq.pop();
    // }
    // result.second.cost = INT_MAX;
    calcComb(0, 0);
    // cout << result.first << '\n';
    cout << min_cost << '\n';
    for (int e : result.first) cout << e << ' ';
    cout << '\n';

    return 0;
}