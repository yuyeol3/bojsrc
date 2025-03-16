#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000001;
int n;
int arr[MAX] = {3, 2, 7, 116, 62, 235, 1, 23, 55, 77};
int tmp[MAX];

void merge(int st, int en) {
    int mid = (st+en) / 2;
    int p = 0, q = 0, r=0;
    int *arr1 = arr+st;  // [st, mid)
    int *arr2 = arr+mid; // [mid, en)
    int n = mid - st;
    int m = en - mid;

    while (p < n && q < m) {
        if (arr1[p] <= arr2[q]) 
            tmp[r++] = arr1[p++];
        else
            tmp[r++] = arr2[q++];
    }

    while (p < n) tmp[r++] = arr1[p++];
    while (q < m) tmp[r++] = arr2[q++];

    for (int i = st; i < en; i++) {
        arr[i] = tmp[i - st];
    }
}

void merge_sort(int st, int en) {
    if (en-st <= 1) return;
    int mid = (st+en) / 2;
    merge_sort(st, mid);
    merge_sort(mid, en);
    merge(st, en);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    
    merge_sort(0, n);
    for (int i = 0; i < n; i++) 
        cout << arr[i] << '\n';
}