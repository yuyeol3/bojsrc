#include <bits/stdc++.h>
using namespace std;

int K;
int N = 6;
int res[6];

void f(int k, int *nums, bool *used) {
    if (k == N) {
        for (int i = 0; i < N; i++) {
            cout << res[i] << ' ';
        }
        cout << '\n';
        return;
    }

    int tmp = 0;
    for (int i = 0; i < K; i++) {
        if (!used[i] && tmp != nums[i] && (k == 0 || (k > 0 && res[k-1] <= nums[i]) ) ) {
            tmp = nums[i];
            res[k] = nums[i];
            used[i] = 1;
            f(k+1, nums, used);
            used[i] = 0;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    for (;;) {
        cin >> K;
        if (K == 0) return 0;
        
        int nums[15];
        bool used[15] = {0,};

        for (int i = 0; i < K; i++)
            cin >> nums[i];

        f(0, nums, used);
        cout << '\n';
    }
}