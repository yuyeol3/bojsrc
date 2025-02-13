#include <bits/stdc++.h>
using namespace std;

int nums[10];
int res[10];
int isused[10];

int N, M;

void f(int k) {
    if (k == M) {
        for (int i = 0; i < M; i++) {
            cout << res[i] << ' ';
        }
        cout << '\n';
        return;
    }

    int tmp = 0;
    for (int i = 0; i < N; i++) {
        if (tmp != nums[i] && ((k == 0) || (k > 0 && nums[i] >= res[k-1])) && !isused[i]) {
            res[k] = nums[i];
            isused[i] = 1;
            tmp = nums[i];
            f(k+1);
            isused[i] = 0;
        }
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
}