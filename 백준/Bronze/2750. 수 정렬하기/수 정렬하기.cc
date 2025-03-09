#include <bits/stdc++.h>
using namespace std;

void bubbleSort(int *arr, int N) {

    for (int i = 0; i < N; i++) {
        for (int j = N - 1; j >= i+1; j--) {
            if (arr[j] < arr[j-1])
                swap(arr[j], arr[j-1]);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;
    int arr[N];

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    bubbleSort(arr, N);

    for (int i = 0; i < N; i++) {
        cout << arr[i] << '\n';
    }
}