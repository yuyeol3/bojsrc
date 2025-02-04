#include <iostream>
using namespace std;
typedef unsigned long long llong;

llong powMod(llong a, llong b, llong c)
{
    if (b == 0)
        return 1;

    llong res = powMod(a, b / 2, c); 
    res = (res * res) % c; 

    if (b % 2 != 0)
        res = (res * a) % c;

    return res;
}

int main()
{
    llong a, b, c;
    cin >> a >> b >> c;
    cout << powMod(a, b, c) << endl;
    return 0;
}
