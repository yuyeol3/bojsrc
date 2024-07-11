#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;

typedef vector<int>::iterator IntItr;

inline void preset() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

int calcHistMaxArea(IntItr st, IntItr ed)
{
    // 종료 조건
    if (ed - st == 0) return 0;
    if (ed - st == 1) return *st;
    
    int half = (ed - st) / 2;
    IntItr mid = (st + half);
    int result = max(
        calcHistMaxArea(st, mid),
        calcHistMaxArea(mid, ed)
    );

    IntItr L = mid - 1;
    IntItr R = mid + 1;
    int minimum = *mid;
    int width = 1;

    while (L != (st - 1) && R != ed) {
        if (*L > *R) {
            minimum = min(*L, minimum);
            --L;
        }
        else {
            minimum = min(*R, minimum);
            ++R;
        }
        ++width;

        result = max(width * minimum, result);
    }
    
    // 아직 L, R 중에 남은 원소가 있으면
    while (L != (st - 1)) {
        ++width;
        minimum = min(*L, minimum);
        --L;
        
        result = max(width * minimum, result);
    }
    while (R != ed)
    {
        ++width;
        minimum = min(*R, minimum);
        ++R;
        
        result = max(width * minimum, result);
    }



    return result;
}

int main()
{
    preset();

    int n, buff;
    vector<int> arr;
    
    scanf("%d", &n);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &buff);
        arr.push_back(buff);
    }    
    cout << calcHistMaxArea(arr.begin(), arr.end()) << '\n';

    return 0;
}