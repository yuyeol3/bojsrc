#include <bits/stdc++.h>
using namespace std;

int N, M;
int nums[10];
int res[10];
void f(int k) {
    if (k == M) {
        for (int i = 0; i < M; i++) {
            cout << res[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 0; i < N; i++) {
        res[k] = nums[i];
        f(k+1);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
        cin >> nums[i];
    sort(nums, nums+N);
    f(0);
    return 0;
}