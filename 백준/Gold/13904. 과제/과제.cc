#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>
using std::cin, std::cout, std::ios_base;
using std::vector, std::deque, std::priority_queue;

struct Assignment
{
    int lday;
    int score;
    Assignment(int l=0, int s=0) : lday(l), score(s) {}
};

struct Cmp
{
    bool operator()(const Assignment a, const Assignment b)
    {
        return a.score < b.score;
    }
};

int getAvailableDay(int tday, vector<bool> &v)
{
    for (int i = tday - 1; i >= 0; --i)
    {
        if (!v[i])
            return i;
    }

    return -1;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    priority_queue<Assignment, deque<Assignment>, Cmp> assignment;
    int n;
    cin >> n;

    int max_l = 0;
    for (int i =0, l, s; i < n; ++i)
    {
        cin >> l >> s;
        if (max_l < l) max_l = l;
        assignment.push(Assignment(l, s));
    }

    int sum = 0;
    vector<bool> day_chk(max_l, false);  // 날짜 체크를 위한 배열 생성
    while (!assignment.empty())
    {
        const Assignment &temp = assignment.top();
        int availDay = getAvailableDay(temp.lday, day_chk); 
        if (availDay != -1)
        {
            day_chk[availDay] = true;
            sum += temp.score;
        }
        assignment.pop(); 
    }

    cout << sum << '\n';

    return 0;
}