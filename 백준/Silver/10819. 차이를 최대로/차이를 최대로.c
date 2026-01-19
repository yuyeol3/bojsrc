#include <stdio.h>
typedef struct _state {
    int step, result, prev, mask;
} State;

State stack[100];
int top = 0;
int nums[10];
int N;

int abs(int x) {
    return (x > 0) ? x : -x;
}

int main(void) {
    scanf("%d", &N);

    for (int i = 0; i < N; i++) scanf("%d", nums + i);

    // State s = 
    stack[top++] = (State){0, 0, 0, 0};

    int maximum = -1;
    while (top != 0) {
        State s = stack[--top];

        if (s.step == N && s.result > maximum) 
            maximum = s.result;
        else {
            for (int i = 0; i < N; i++) {
                if ((s.mask >> i) & 1) continue;
                
                stack[top++] = (State){
                    s.step + 1,
                    (s.step > 0 ? 
                        s.result + abs(nums[i] - nums[s.prev]) :
                        s.result
                    ),
                    i,
                    s.mask | (1 << i)
                };

            }
        }
    }

    printf("%d\n", maximum);
    return 0;
}