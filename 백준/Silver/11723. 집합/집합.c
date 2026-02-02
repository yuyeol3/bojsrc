#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool set[30];

int main(void) {
    int n;
    scanf("%d", &n);

    char cmd[10];
    int x;
    while (n-->0) {
        scanf("%s", cmd);

        if (!strcmp(cmd, "add")) {
            scanf("%d", &x);
            set[x] = true;
        }
        else if (!strcmp(cmd, "remove")) {
            scanf("%d", &x);
            set[x] = false;
        }
        else if (!strcmp(cmd, "check")) {
            scanf("%d", &x);
            printf("%d\n", set[x]);
        }
        else if (!strcmp(cmd, "toggle")) {
            scanf("%d", &x);
            set[x] = !set[x];
        }
        else if (!strcmp(cmd, "all")) {
            for (int i = 1; i <= 20; i++) 
                set[i] = true;
        }
        else if (!strcmp(cmd, "empty")) {
            for (int i = 1; i <= 20; i++) 
                set[i] = false;
        }
    }
    return 0;
}