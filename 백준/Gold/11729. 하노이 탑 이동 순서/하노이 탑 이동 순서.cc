#include <bits/stdc++.h>
using namespace std;

void hanoi(int n, int from , int via, int to) {
    if (n == 1) {
        cout << from << ' ' << to << '\n';
        return;
    }
    
    hanoi(n-1, from, to, via);
    cout << from << ' ' << to << '\n';
    hanoi(n-1, via, from, to);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N;
    cin >> N;
    cout << (1 << N) - 1 << '\n';
    hanoi(N, 1, 2, 3);
}