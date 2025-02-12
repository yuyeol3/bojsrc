#include <bits/stdc++.h>
using namespace std;

int nums[10];
int flag[10];
int N, M;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;
    // for (int i = N - 1; i >= M; i++) {
    //     flag[i] = 1;
    // }
    fill(flag + M, flag + N, 1);


    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
    sort(nums, nums+N);

    do  {
        for (int i = 0; i < N; i++) {
            if (flag[i] == 0) {
                cout << nums[i] << ' ';
            }
        }
        cout << '\n';

    } while (next_permutation(flag, flag+N));

}