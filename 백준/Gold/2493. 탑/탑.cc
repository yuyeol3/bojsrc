#include <bits/stdc++.h>
using namespace std;


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);


    int N;
    cin >> N;

    int nums[N];
    stack<pair<int, int>> stk;
    int results[N] = {0,};

    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    for (int i = N-1; i >= 0; i--) {
        while (!stk.empty()) {
            if (nums[i] > stk.top().first) {
                results[stk.top().second] = i+1;
                stk.pop();
            } else break;
        }
        stk.push(make_pair(nums[i], i));
    }

    for (int e : results) {
        cout << e << ' ';
    }
    cout << '\n';

    return 0;
}

/*
------     6
---------  9
-----      5
-------    7
----       4

0 0 2 2 4


---------  9 ) 
------     6 )(
-----      5 )(
-------    7 )( 
----       4 (



0 1 2 1 4

     
해결이 되지 않은 어떤 구간 -> 오 - 왼 내림차순이란 뜻

-----------
--------
-
--
---
----------
*/