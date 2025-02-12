#include <bits/stdc++.h>
using namespace std;

int N, M;
int flags[10];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;

    for (int i = N-1; i >= M; i--)
        flags[i] = 1;

    // cout << '\n';

    
    do {
        for (int i = 0; i < N; i++) 
            if (flags[i] == 0)
                cout << i + 1 << ' ';
            // cout << nums[i];
        cout << '\n';
    } while (next_permutation(flags, flags+N));
}
