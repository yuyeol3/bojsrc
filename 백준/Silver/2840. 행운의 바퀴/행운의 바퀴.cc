#include <deque>
#include <cstdio>
using namespace std;

inline void incLoc(deque<char> &dq, int &location) {
    location = (location == dq.size() - 1) ? 0 : location + 1;
}
inline void decLoc(deque<char> &dq, int &location) {
    location = (location == 0) ? dq.size() - 1 : location - 1 ;
}
inline int alphaToKey(char alphabet) {
    return alphabet - 'A';
}
// inline void decLoc(deque<char> &dq, int &)

int main() {
    int N, K;
    scanf("%d %d", &N, &K);
    deque<char> roulette(N, '?');
    deque<bool>  visited(26, false);

    int  pointer = 0;  // 화살표가 처음으로 가르키고 있는 칸을 0이라 하자
    bool unexist = false;
    for (int i = 0; i < K; ++i) {
        int changed;
        char alphabet;
        scanf("%d %c", &changed, &alphabet);



        for (int j = 0; j < changed; ++j)
            decLoc(roulette, pointer);

        if (roulette[pointer] == '?') {
            if (visited[alphaToKey(alphabet)]) {
                unexist = true;
                break;
            }
            visited[alphaToKey(alphabet)] = true;
            roulette[pointer] = alphabet;
        }
        else if ( roulette[pointer] != alphabet ){
            unexist = true;
            break;
        }
    }

    if (unexist) {
        printf("!\n");
    } 
    else {
        for (int i = 0; i < N; ++i) {
            printf("%c", roulette[pointer]);
            incLoc(roulette, pointer);
        }
        printf("\n");
    }
    return 0;
}