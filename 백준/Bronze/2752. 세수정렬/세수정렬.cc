#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int arr[3];
    cin >> arr[0] >> arr[1] >> arr[2];

    for (int i = 0; i < 2; i++) {
        int min_idx = i;
        for (int j = i + 1; j < 3; j++) {
            if (arr[min_idx] > arr[j])
                min_idx = j;
        }

        swap(arr[i], arr[min_idx]);
    }

    for (int i = 0; i < 3; i++)
        cout << arr[i] << ' ';
    
    return 0;
}