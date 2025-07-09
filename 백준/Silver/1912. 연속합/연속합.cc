#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;

    long long arr[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];


    long long t = arr[0];
    long long maxi = arr[0];
    for (int i = 1; i < n; i++) {
        t = max(t+arr[i], arr[i]);
        maxi = max(t, maxi);
    }
    cout << maxi << '\n';
}

