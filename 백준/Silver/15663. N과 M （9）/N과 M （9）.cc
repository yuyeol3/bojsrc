#include <bits/stdc++.h>
using namespace std;

int nums[10];
bool used[10];
int res[10];
int M, N;

/*
숫자 중복은 가능하지만
수열 자체는 중복되면 안됨

used 처리하는법


1. 
*/
// void f(int k, int idx) {
//     if (idx > N || k > M) return;
//     if (k == M) {
//         // for (int i = 0; i < N; i++) {
//         //     if (used[i])
//         //         cout << nums[i] << ' ';
//         // }
//         for (int i = 0; i < M; i++) {
//             cout << res[i] << ' ';
//         }
//         cout << '\n';
//         return;
//     }

//     res[k] = nums[idx];
//     used[idx] = 1;
//     f(k+1, idx+1);
//     used[idx] = 0;
//     f(k, idx+1);

// }

unordered_set<string> rset;

void f(int k) {
    if (k == M) {
        string s = "";
        for (int i = 0; i < M; i++) {
            s += to_string(res[i]) + " ";
        }

        if (rset.find(s) == rset.end()) {
            rset.insert(s);
            cout << s << '\n';
        }
        return;
    }

    for (int i = 0; i < N; i++) {
        if (!used[i]) {
            res[k] = nums[i];
            used[i] = 1;
            f(k+1);
            used[i] = 0;
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
    // do {
    //     for (int i = 0; i < N; i++)
    //         cout << nums[i] << ' ';
    //     cout << '\n';
    // } while(next_permutation(nums, nums+M));
}

/*
1 7 9 9

1 7
1 9
7 1
7 9
9 1
9 7
9 9



*/