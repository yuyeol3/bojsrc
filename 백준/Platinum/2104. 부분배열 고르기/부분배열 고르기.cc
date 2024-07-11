#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

typedef vector<int>::iterator IntItr;



long long calcArrScore(IntItr st, IntItr ed)
{
    // 종료 조건
    if (ed - st == 1) 
        return (long long) (*st) * (*st);
    
    int half = (ed - st) / 2;
    IntItr mid = (st + half);
    long long maxScore = max(calcArrScore(st, mid), calcArrScore(mid, ed));

    IntItr L = mid - 2;
    IntItr R = mid + 1;
    int minimum = *mid;
    long long eleSum = *mid;


    if (mid - 1 != st - 1) {
        eleSum += *(mid - 1);
        minimum = min(minimum, *(mid - 1));

        maxScore = max(maxScore, (long long) eleSum * minimum);
    }

    while (L != (st - 1) && R != ed) {
        long long leftExpand = (eleSum + *L) * min(minimum, *L);
        long long rightExpand = (eleSum + *R) * min(minimum, *R);

        if (leftExpand > rightExpand) {
            eleSum += *L;
            minimum = min(*L, minimum);
            --L;
        }
        else {
            eleSum += *R;
            minimum = min(*R, minimum);
            ++R;
        }

        maxScore = max((long long) eleSum * minimum, maxScore);
    }
    
    // 아직 L, R 중에 남은 원소가 있으면
    while (L != (st - 1)) {
        eleSum += *L;
        minimum = min(*L, minimum);
        --L;
        
        maxScore = max((long long) eleSum * minimum, maxScore);
    }
    while (R != ed)
    {
        eleSum += *R;
        minimum = min(*R, minimum);
        ++R;
        
        maxScore = max((long long)eleSum * minimum, maxScore);
    }



    return maxScore;
}

int main()
{
    int n, buff;
    vector<int> arr;
    
    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> buff;
        arr.push_back(buff);
    }    
    cout << calcArrScore(arr.begin(), arr.end()) << '\n';

    return 0;
}