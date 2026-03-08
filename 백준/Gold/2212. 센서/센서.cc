#include <ios>
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using std::cin;
using std::cout;
using std::vector;
using std::sort;
using std::priority_queue;
using std::ios_base;


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int n, k;

    cin >> n >> k;
    // k가 n보다 크거나 같은 경우 집중국은 센서 하나씩만 맡으면 되므로..
    if (n <= k)
    {
        cout << '0' << '\n';
        return 0;
    }

    vector<int> sensors(n);
    for (int x, i = 0; i < n; ++i)
    {
        cin >> x;
        sensors[i] = x;
    }
    sort(sensors.begin(), sensors.end());

    priority_queue<int> pq_dist;
    for (unsigned int i = 1; i < n; ++i)
        pq_dist.push(sensors[i] - sensors[i - 1]);

    // 가장 큰 거리 k-1개만큼 제외 가능
    for (unsigned int i = 0; i < k - 1; ++i)
        pq_dist.pop();    

    // 남은 거리들은 모두 더해주기    
    int sum = 0;
    while (!pq_dist.empty())
    {
        sum += pq_dist.top();
        pq_dist.pop();
    }
    cout << sum << '\n';

    return 0;
}