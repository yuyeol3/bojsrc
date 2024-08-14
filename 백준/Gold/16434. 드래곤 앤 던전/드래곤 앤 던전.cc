#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
    int N, ATK;
    scanf("%d %d", &N, &ATK);

    int rooms[N][3];

    for (int i = 0; i < N; ++i) {
        // t_i, a_i, h_i
        scanf("%d %d %d", &rooms[i][0], &rooms[i][1], &rooms[i][2]);
    }

    long long ub = 123456000000000000;
    // long long ub = 50;
    long long lb = 0;
    // long long lb = 40;

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
            /**
             * 용사 선공, 몹 후공
             * 1. 몹 피 / 용사 공격력
             * 2. 용사 피 / 몹 공격력
             * 
             * 2 >= 1이면 용사가 이김
             * 2 < 1 이면 몹이 이김 (용사 피 0 이하)
             * 
             * 이겼을 경우 피 계산
             * 1. => 2
             * 2. => 3라 하자
             * 공격 순서는
             * 용 몹 용(<-여기서 몹이 죽음)
             * 즉 용사 피는 ((1.) - 1) * 몹 공격력 만큼이 됨
             * 
             *  3 3인 경우
             *  용 몹 용 몹 용 / 몹
             *  */   
                long long M_atk = rooms[i][1];
                long long M_hp = rooms[i][2];

                long long HAtkCnt = (M_hp / H_atk) + (M_hp % H_atk > 0 ? 1 : 0);  // 1. 몹 피 / 용사 공격력 (=용사가 공격하는 횟수)
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
        // printf("mid : %lld, H_curhp : %lld\n", mid, H_curhp);

        if (H_curhp > 0) {
            ub = mid;
        } else {
            lb = mid;
        }
    }

    return 0;
}