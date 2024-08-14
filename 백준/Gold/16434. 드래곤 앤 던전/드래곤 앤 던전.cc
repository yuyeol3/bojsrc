#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
    int N, ATK;
    scanf("%d %d", &N, &ATK);

    int rooms[N][3];

    for (int i = 0; i < N; ++i) {
        scanf("%d %d %d", &rooms[i][0], &rooms[i][1], &rooms[i][2]);
    }

    long long ub = 123455876544000001;
    long long lb = 0;

    while (ub > lb) {
        long long mid = (ub+lb)/2;
        if (lb == mid) {
            printf("%lld\n", ub);
            break;
        }

        long long H_curhp = mid;
        long long H_atk = ATK;
        for (int i = 0; i < N; ++i) {
            if (rooms[i][0] == 1) {

                int M_atk = rooms[i][1];
                int M_hp = rooms[i][2];

                long long HAtkCnt = ( (long long) M_hp / H_atk) + (M_hp % H_atk > 0 ? 1 : 0);  // 1. 몹 피 / 용사 공격력 (=용사가 공격하는 횟수)
                long long MAtkCnt = (H_curhp / M_atk) + (H_curhp % M_atk > 0 ? 1 : 0);  // 2. 용사 피 / 몹 공격력 (=몬스터가 공격하는 횟수)

                if (MAtkCnt >= HAtkCnt) {
                    H_curhp -= (HAtkCnt - 1) * M_atk;
                }
                else {
                    H_curhp = 0;
                    break; 
                }
                    
            } else {
                H_curhp = min(mid, (long long) rooms[i][2] + H_curhp);
                H_atk += (long long) rooms[i][1];
            }
        }

        if (H_curhp > 0) {
            ub = mid;
        } else {
            lb = mid;
        }
    }

    return 0;
}