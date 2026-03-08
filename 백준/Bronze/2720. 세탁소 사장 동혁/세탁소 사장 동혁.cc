#include <algorithm>
#include <iostream>
#include <vector>
using std::cin;
using std::cout;
using std::vector;
using std::for_each;

void get_change(int change)
{
    int rem = change;
    int coins_to_give[4] = {0};
    int units[] = {25, 10, 5};

    for (int i = 0; i < 3; i++)
    {
        coins_to_give[i] = rem / units[i];
        rem = rem % units[i];
    }
    coins_to_give[3] = rem;

    cout << coins_to_give[0] << ' ' << coins_to_give[1] << ' ' << coins_to_give[2] << ' ' << coins_to_give[3] << '\n';
}

int main()
{
    int n;
    cin >> n;
    int changes[n];
    for (int i = 0; i < n; i++)
        cin >> changes[i];

    for_each(changes, changes+n, get_change);
    
    return 0;
}