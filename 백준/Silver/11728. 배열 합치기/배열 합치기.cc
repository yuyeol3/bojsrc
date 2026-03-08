#include <bits/stdc++.h>
using namespace std;

const int maxLength = 1000001;
int arr1[maxLength];
int arr2[maxLength];
// int res[maxLength*2];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int N, M;
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> arr1[i];
    }

    for (int i = 0; i < M; i++) {
        cin >> arr2[i];
    }

    int p = 0, q = 0, r = 0;
    while (p < N && q < M) {
        if (arr1[p] < arr2[q]) {
            cout << arr1[p] << ' ';
            p++;
        }
        else {
            cout << arr2[q] << ' ';
            q++;
        }
    }

    while (p < N) {
        cout << arr1[p] << ' ';
        p++;
    }

    while (q < M) {
        cout << arr2[q] << ' ';
        q++;
    }
    cout << '\n';

}