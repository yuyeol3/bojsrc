#include <string>
#include <vector>

using namespace std;

bool isValidSolution(int level, vector<int> &diffs, vector<int> &times, long long limit) {
    if (level == 0) return false;
    for (int i = 0; i < diffs.size(); i++) {
        int diff = diffs[i];
        int time_cur = times[i];
        int time_prev = i ? times[i-1] : 0;
        
        if (diff <= level) limit -= time_cur;
        else {
            limit -= (diff - level) * (time_cur + time_prev) + time_cur;
        }
        
        if (limit < 0) return false;
    }
    if (limit < 0) return false;
    return true;
}

int solution(vector<int> diffs, vector<int> times, long long limit) {

    int maxLev = 0;
    int minLev = 1;
    for (auto diff : diffs) maxLev = max(maxLev, diff);
    
    int ub = maxLev + 1;
    int lb = minLev;
    
    while (lb < ub) {
        int mid = (ub+lb) / 2;
        bool midValid = isValidSolution(mid, diffs, times, limit);
        bool midPrevValid = isValidSolution(mid - 1, diffs, times, limit);
        if (midValid && !midPrevValid) {
            return mid;            
        }
        else if (midPrevValid) {
            ub = mid-1;
        }
        else {
            lb = mid+1;
        }
    }
    
    // for (int i = 1; i <= maxLev; i++) {
    //     if (isValidSolution(i, diffs, times, limit)) return i;
    // }
}