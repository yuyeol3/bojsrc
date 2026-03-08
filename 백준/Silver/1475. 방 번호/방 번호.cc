#include <bits/stdc++.h>
using namespace std;

int counts[10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    string number;
    cin >> number;

    for (char c : number) {
        // cout << ((int) (c - '0')) << '\n';
        if (c == '6' || c == '9') 
            counts[6]++;
        else counts[c - '0']++;
    }

    counts[6] = counts[6] % 2 == 0 ? 
                counts[6] / 2 : counts[6] / 2 + 1;

    cout <<  *max_element(counts, counts+9) << '\n';

    return 0;
}
/*

9
96
69
169

*/