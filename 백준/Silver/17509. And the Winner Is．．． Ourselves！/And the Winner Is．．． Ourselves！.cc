#include <iostream>
#include <vector>
#include <algorithm>
using std::cin;
using std::cout;
using std::vector;
using std::sort;

struct Case
{
    int x;
    int y;

    Case(int _x, int _y): x(_x), y(_y) {}
};

bool comp(Case &a, Case &b)
{
    return a.x < b.x;
}



int main()
{
    vector<Case> cases;
    int x, y;
    for (int i = 0; i < 11; i++) {
        cin >> x;
        cin >> y;
        cases.push_back(Case(x, y));
    }

    sort(cases.begin(), cases.end(), comp);
    int min_p = 0, agg_t = 0;

    for (int i = 0; i < 11; i++)
    {
        agg_t += cases[i].x;
        min_p += agg_t + cases[i].y * 20;
    }

    cout << min_p << '\n';
    return 0;
}