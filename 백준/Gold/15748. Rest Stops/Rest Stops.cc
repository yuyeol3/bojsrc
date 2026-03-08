// https://www.acmicpc.net/problem/15748
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void ios_preset()
{
    std::ios_base::sync_with_stdio(false); 
	std::cin.tie(NULL); 
	std::cout.tie(NULL); 
}

struct Stop
{
    int pos;
    int tastiness;
    Stop (int p, int t) : pos(p), tastiness(t) {}
};

int main()
{
    ios_preset();
    int l, n, rf, rb;
    cin >> l >> n >> rf >> rb;
    vector<Stop> stops;

    for (int i = 0, p, t; i < n; ++i)
    {
        cin >> p >> t;
        stops.push_back(Stop(p, t));    
    }
    sort(stops.begin(), stops.end(),
    [](const Stop &a, const Stop &b) -> bool {
            return a.tastiness > b.tastiness;
        }
    );

    long maxT = 0;
    int prev = 0;

    for (int i = 0; i < n; ++i)
    {
        if (stops[i].pos > prev)
        {
            maxT += static_cast<long>((stops[i].pos - prev)) * (rf - rb) * stops[i].tastiness;
            prev = stops[i].pos;
        }
    }

    cout << maxT << '\n';

    return 0;
}