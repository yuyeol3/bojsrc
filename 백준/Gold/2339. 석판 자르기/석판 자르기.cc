#include <iostream>
#include <vector>
using namespace std;

namespace StoneStat {
    enum {BLANK,IMPURITY,CRYSTAL};
}
namespace CutStat {
    enum {INITIAL,VERTICAL,HORIZENTAL};
}

struct Platelet {
    vector<vector<int>> *plate;
    int st_row, st_col;
    int row_sz, col_sz;

    Platelet(vector<vector<int>> *pl, int row, int col, int rsize, int csize)
    : plate(pl), st_row(row), st_col(col), row_sz(rsize), col_sz(csize)
    {}

    vector<int>::iterator operator[](int idx)
    {
        return (*plate)[st_row + idx].begin() + st_col;
    }

};

long long calcProbability(int originalSz, Platelet plate, int prevCut=CutStat::INITIAL) {
    // 크기가 0이면 리턴
    if (plate.col_sz == 0 || plate.row_sz == 0)
        return 1;
    
    // 보석 위치랑 불순물 위치 구하기 
    vector<pair<int, int>> crystals;
    vector<pair<int, int>> impurities;

    for (int i = 0; i < plate.row_sz; ++i) {
        for (int j = 0; j < plate.col_sz; ++j) {
            if (plate[i][j] == StoneStat::CRYSTAL)
                crystals.push_back(make_pair(i+plate.st_row,j+plate.st_col));
            else if (plate[i][j] == StoneStat::IMPURITY)
                impurities.push_back(make_pair(i+plate.st_row,j+plate.st_col));
        }
    }

    // 종료 조건
    if (crystals.size() == 1 && impurities.size() == 0) 
        return 1;

    if (crystals.size() == 0)
        return 0;

    if (crystals.size() - impurities.size() != 1)
        return 0;

    long long probability = 0;
    for (pair<int, int> impurity : impurities) {
        bool cutByRow, cutByCol;
        cutByRow = cutByCol = true;
        for (pair<int, int> crystal : crystals) {
            if (!cutByRow && !cutByCol)
                break;

            if (crystal.first == impurity.first)
                cutByRow = false;
            else if (crystal.second == impurity.second)
                cutByCol = false;
        }

        if (cutByRow && prevCut != CutStat::HORIZENTAL) {
            long long a,b;
            a = calcProbability(originalSz,
            Platelet(plate.plate, plate.st_row, plate.st_col, abs(plate.st_row-impurity.first), plate.col_sz),
            CutStat::HORIZENTAL);
            b = calcProbability(originalSz,
            Platelet(plate.plate, impurity.first+1, plate.st_col, abs(plate.st_row+plate.row_sz-impurity.first)-1, plate.col_sz),
            CutStat::HORIZENTAL);
            probability += a*b;
        }
        if (cutByCol && prevCut != CutStat::VERTICAL) {
            long long a,b;
            a = calcProbability(originalSz,
            Platelet(plate.plate, plate.st_row, plate.st_col, plate.row_sz, abs(plate.st_col-impurity.second)),
            CutStat::VERTICAL);
            b = calcProbability(originalSz,
            Platelet(plate.plate, plate.st_row, impurity.second+1, plate.row_sz, abs(plate.st_col+plate.col_sz-impurity.second)-1),
            CutStat::VERTICAL);
            probability += a*b;
        }
    }

    return probability;
}

int main() {
    int n;
    scanf("%d", &n);
    vector<vector<int>> plate(n, vector<int>(n));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            scanf("%d", &plate[i][j]);
        }
    }
    // 경우의 수 계산
    long long res = calcProbability(n, Platelet(&plate, 0, 0, n, n));
    printf("%lld\n", res ? res : -1);
    return 0;
}
