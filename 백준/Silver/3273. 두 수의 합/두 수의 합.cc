#include <bits/stdc++.h>
using namespace std;

bool arr[2000001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N, X;
    cin >> N;
    int nums[N];
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
    cin >> X;
    
    // sort(nums, nums+N);

    int count = 0;
    for (int i = 0; i < N; i++) {
        int counterpart = X - nums[i];
        if ( counterpart >= 1 && arr[counterpart] ) 
            count++;
        arr[nums[i]] = true;
    }

    cout << count << '\n';
    return 0;
}